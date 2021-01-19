<?php

namespace App\Http\Controllers\Transfert;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Client;
use App\Models\Transfert;
use App\Http\Services\IdMaker;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\LoadFlux;

class AddTransfertController extends Controller
{
    public function addTransfert() {

        $validator = Validator::make(request()->all(), [
            'montant_transfert' => ['required', 'regex:/[0-9]+/'],
        ]);

        if($validator->fails())
            return response()->json($validator->messages(), 201);

        if(!$sender = Client::find(request()->get('sender_id')))
        	return response()->json(["message" => "Client envoyeur introuvable ..."], 201);

        if(!$receiver = Client::find(request()->get('receiver_id')))
        	return response()->json(["message" => "Client bénéficiaire introuvable ..."], 201);

        $montant = request()->get('montant_transfert');
        if($montant > $sender->solde)
        	return response()->json(["message" => "La solde n'est pas suffisante ..."], 201);
        

        $sender->solde -= $montant;
        $sender->save();
        $receiver->solde += $montant;
        $receiver->save();

        $transfert = new Transfert([
            'id' => IdMaker::getId('Transfert'),
            'receiver_id' => $receiver->id,
            'montant_transfert' => $montant
        ]);

        $sender->transferts()->save($transfert);
        
        $sender->loadMissing(LoadFlux::flux(request()->get("year")));
        $receiver->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json([$sender, $receiver], 200);
    }
}
