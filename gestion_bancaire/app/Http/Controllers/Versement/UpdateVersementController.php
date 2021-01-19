<?php

namespace App\Http\Controllers\Versement;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Versement;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\LoadFlux;

class UpdateVersementController extends Controller
{
    public function updateVersement() {

    	$validator = Validator::make(request()->all(), [
            'montant_versement' => ['required', 'integer', 'min:0'],
        ]);

        if($validator->fails())
            return response()->json($validator->messages(), 201);

        $versement = Versement::find(request()->get('id'));

        $versement_delta = request()->get('montant_versement') - $versement->montant_versement;

        $versement->montant_versement = request()->get('montant_versement');
        $versement->save();

        $versement->client->solde += $versement_delta;
        $versement->client->save();

        $client = $versement->client;
        
        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);
    }
}
