<?php

namespace App\Http\Controllers\Transfert;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Client;
use App\Models\Transfert;
use App\Http\Services\LoadFlux;

class CancelTransfertController extends Controller
{
    public function cancelTransfert() {

        if(!$transfert = Transfert::find(request()->query('transfer_id')))
        	return response()->json(["message" => "Transfert introuvable ..."], 201);
        

        $sender = $transfert->client;
        $sender->solde += $transfert->montant_transfert;
        $sender->save();

        $receiver = Client::find($transfert->receiver_id);
        $receiver->solde -= $transfert->montant_transfert;
        $receiver->save();

        $transfert->delete();

        $sender->loadMissing(LoadFlux::flux(request()->query("year")));
        $receiver->loadMissing(LoadFlux::flux(request()->query("year")));

        return response()->json([$sender, $receiver], 200);
    }
}
