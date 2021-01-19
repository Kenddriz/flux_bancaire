<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
Route::post("register", "Auth\RegisterController@register");
Route::post("login", "Auth\LoginController@login");

//Route::group(['middleware' => ['jwt.verify']], function() {
	
	Route::post("create_client", "Client\CreateClientController@createClient");
	Route::get("search_client", "Client\SearchClientController@searchClient");
	Route::post("update_client", "Client\UpdateClientController@updateClient");
	Route::get("delete_client", "Client\DeleteClientController@deleteClient");
	Route::get("find_one_client", "Client\FindOneClientController@findOneClient");

	Route::post("add_versement", "Versement\AddVersementController@addVersement");
	Route::post("update_versement", "Versement\UpdateVersementController@updateVersement");
	Route::get("delete_versement", "Versement\DeleteVersementController@deleteVersement");

	Route::post("add_retrait", "Retrait\AddRetraitController@addRetrait");
	Route::post("update_retrait", "Retrait\UpdateRetraitController@updateRetrait");
	Route::get("delete_retrait", "Retrait\DeleteRetraitController@deleteRetrait");

	Route::post("add_transfert", "Transfert\AddTransfertController@addTransfert");
	Route::get("cancel_transfert", "Transfert\CancelTransfertController@cancelTransfert");

//});
