<?php

namespace App\Http\Controllers\Client;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Client;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\LoadFlux;

class UpdateClientController extends Controller
{
	public function updateClient() {

		$validator = Validator::make(request()->all(), [
            'nom' => ['required', 'string', 'max:60'],
            'solde' => ['required', 'integer', 'min:0'],
        ]);

		if($validator->fails())
            return response()->json($validator->messages(), 201);

        $client = Client::find(request()->get("id"));
        $client->nom = request()->get("nom");
        $client->solde = request()->get("solde");
        $client->save();
        
        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);

	}
}
