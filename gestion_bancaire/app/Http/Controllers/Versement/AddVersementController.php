<?php

namespace App\Http\Controllers\Versement;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Versement;
use App\Models\Client;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\IdMaker;
use App\Http\Services\LoadFlux;

class AddVersementController extends Controller
{
	public function addVersement(){

		$validator = Validator::make(request()->all(), [
            'versement' => ['required', 'integer', 'min:0'],
        ]);

        if($validator->fails())
            return response()->json($validator->messages(), 201);

        $client = Client::find(request()->get("id"));
        $client->solde += request()->get("versement");
		$client->save();
		
        $versement = new Versement([
        	'id' => IdMaker::getId('Versement'),
        	'montant_versement' => request()->get("versement")
        ]);

        $client->versements()->save($versement);

        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);
	}
}
