<?php

namespace App\Http\Controllers\Versement;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Versement;
use App\Http\Services\LoadFlux;

class DeleteVersementController extends Controller
{
    //
    public function deleteVersement() {

    	$versement = Versement::find(request()->query('id'));

        if(!$versement)
        	return response()->json(array(
        		"message" => "Versement introuvable"
        	), 201);

        $client = $versement->client;

        if(request()->query("mode") == 'cancel') {
            $client->solde -= $versement->montant_versement;
            $client->save();
        }

        $versement->delete();

        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);
    }
}
