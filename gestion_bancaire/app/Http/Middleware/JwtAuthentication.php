<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;

use JWTAuth;
use Exception;
use Tymon\JWTAuth\Http\Middleware\BaseMiddleware;

class JwtAuthentication extends BaseMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle(Request $request, Closure $next)
    {
        try {
                if(!$user = JWTAuth::parseToken()->authenticate())
                     return response()->json(["message" => 'user_not_found'], 201);
            }
        catch (Exception $e) {
            if ($e instanceof \Tymon\JWTAuth\Exceptions\TokenExpiredException){
                return response()->json(["message" => 'token expiré'], 201);
            }else if ($e instanceof \Tymon\JWTAuth\Exceptions\TokenInvalidException){
                return response()->json(["message" => 'token invalide'], 201);
            }else{
                return response()->json(["message" =>'token absent'], 201);
            }
        }
        return $next($request);
    }
}
