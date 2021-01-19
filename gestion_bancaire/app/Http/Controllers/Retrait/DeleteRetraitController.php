<?php

namespace App\Http\Controllers\Retrait;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Retrait;
use App\Http\Services\LoadFlux;

class DeleteRetraitController extends Controller
{
    //
    public function deleteRetrait() {

    	$retrait = Retrait::find(request()->query('id'));

        if(!$retrait)
        	return response()->json(array(
        		"message" => "Retrait introuvable"
        	), 201);

        $client = $retrait->client;

        if(request()->query('mode') == 'cancel') {
            $client->solde += $retrait->montant_retrait;
            $client->save();
        }

        $retrait->delete();

        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);
    }
}
