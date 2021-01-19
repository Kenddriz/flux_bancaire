<?php

namespace App\Http\Controllers\Retrait;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Retrait;
use Illuminate\Support\Facades\Validator;
use App\Http\Services\LoadFlux;


class UpdateRetraitController extends Controller
{
    //
    public function updateRetrait() {

    	$validator = Validator::make(request()->all(), [
            'montant_retrait' => ['required', 'integer', 'min:0'],
        ]);

        if($validator->fails())
            return response()->json($validator->messages(), 201);

        $retrait = Retrait::find(request()->get('id'));
        $retrait_delta = request()->get('montant_retrait') - $retrait->montant_retrait;

        $retrait->montant_retrait = request()->get('montant_retrait');
        $retrait->save();

        $retrait->client->solde -= $retrait_delta;
        $retrait->client->save();

        $client = $retrait->client;

        $client->loadMissing(LoadFlux::flux(request()->get("year")));

        return response()->json($client, 200);
    }
}
