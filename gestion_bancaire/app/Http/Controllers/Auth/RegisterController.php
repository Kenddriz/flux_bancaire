<?php
namespace App\Http\Controllers\Auth;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Validator;
use App\Models\User;
use Illuminate\Support\Facades\Hash;
use JWTAuth;
use App\Http\Services\IdMaker;

class RegisterController extends Controller
{
    public function register()
    {
        $id = IdMaker::getId('User');

        $validator = Validator::make(request()->all(), [
            'username' => 'required|unique:users|string|max:15',
            'password' => 'required|string|min:5',
        ]);

        if($validator->fails()){
            return response()->json($validator->messages(), 201);
        }

        $user = User::create([
            'id'=> $id,
            'username' => request()->get('username'),
            'password' => Hash::make(request()->get('password'))
        ]);

        //$token = JWTAuth::fromUser($user);

        return response()->json(compact('user'), 200);
    }
}
