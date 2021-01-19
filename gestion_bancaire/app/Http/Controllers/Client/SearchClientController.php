<?php

namespace App\Http\Controllers\Client;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\Client;
use App\Http\Services\LoadFlux;

class SearchClientController extends Controller
{
    public function searchClient() {

    	$keyword = request()->query("keyword");
        
    	$clients = Client::with(LoadFlux::flux(request()->query("year")))
    		->where("id", "=", $keyword)
    		->orWhere("nom", "like", "%".$keyword."%")
    		->orderBy('created_at', 'desc')
            ->limit(8)
            ->get();

        return response()->json($clients, 200);
    }
}
