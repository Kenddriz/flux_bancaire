<?php

namespace App\Http\Controllers\Auth;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\User;
use JWTAuth;

class LoginController extends Controller
{
	public function login() {

		$credentials = request()->only('username', 'password');
		
		if (!$token = JWTAuth::attempt($credentials))
            return response()->json(['message'=>"Echec d'authentification"], 201);

        $user = JWTAuth::user();
        return response()->json(compact('user','token'), 200);
	}
}
