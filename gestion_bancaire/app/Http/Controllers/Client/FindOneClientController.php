<?php

namespace App\Http\Controllers\Client;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Client;
use App\Http\Services\LoadFlux;

class FindOneClientController extends Controller
{
    public function findOneClient() {

    	$keyword = request()->query("keyword");

    	/**Try to search one matched client when not with id*/
    	$client = Client::where("id", "<>", request()->query("sender_id"))
			->where(function ($query) use($keyword) {
			    $query->where('id', "=", $keyword)
			    ->orWhere('nom', "like","%".$keyword."%");
			})
			->first();

    	if(!$client)
    		return response()->json(["message" => "Aucun client correspondant à la recherche ..."], 201);

    	$client->loadMissing(LoadFlux::flux(request()->query("year")));

        return response()->json($client, 200);
    }
}
