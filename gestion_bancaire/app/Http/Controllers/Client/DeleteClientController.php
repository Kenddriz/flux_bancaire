<?php

namespace App\Http\Controllers\Client;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Client;

class DeleteClientController extends Controller
{
    //
    public function deleteClient() {

    	$client = Client::find(request()->query("id"));

    	if(!$client)
        	return response()->json(array(
        		"message" => "Client introuvable"
        	), 201);
        
        /**delete transactions*/
        $client->versements()->delete();
        $client->retraits()->delete();
        /**delete the client*/
        $client->delete();
        return response()->json(array("id" => request()->query("id")), 200);

    }
}
