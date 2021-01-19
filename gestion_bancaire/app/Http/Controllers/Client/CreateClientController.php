<?php

namespace App\Http\Controllers\Client;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

use App\Models\Client;
use App\Http\Services\IdMaker;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\LoadFlux;

class CreateClientController extends Controller
{
	public function createClient() {

        $validator = Validator::make(request()->all(), [
            'nom' => ['required', 'string', 'max:60'],
            'solde' => ['required', 'regex:/[0-9]+/'],
        ]);

        if($validator->fails())
            return response()->json($validator->messages(), 201);

        $client = Client::create([
            'id'=> IdMaker::getId('Client'),
            'nom' => request()->get('nom'),
            'solde' => request()->get('solde')
        ]);
        
        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client,200);
	}
}
