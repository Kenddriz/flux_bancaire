<?php

namespace App\Http\Controllers\Retrait;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Retrait;
use App\Models\Client;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\IdMaker;
use App\Http\Services\LoadFlux;

class AddRetraitController extends Controller
{
	public function addRetrait() {
        
		$validator = Validator::make(request()->all(), [
            'retrait' => ['required', 'integer', 'min:0'],
        ]);

        if($validator->fails())
            return response()->json($validator->messages(), 201);

        $client = Client::find(request()->get("id"));

        $montant_retrait = request()->get("retrait");
        /**Valeur à rétirer doit <= solde*/
        if($client->solde < $montant_retrait)
            return response()->json([
                "message" => "La solde est insuffisante pour un retrait de ".$montant_retrait." Ar ."
            ], 201);

        $client->solde -= $montant_retrait;
		$client->save();
		
        $retrait = new Retrait([
        	'id' => IdMaker::getId('Retrait'),
        	'montant_retrait' => $montant_retrait
        ]);

        $client->retraits()->save($retrait);

        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);
	}
}
