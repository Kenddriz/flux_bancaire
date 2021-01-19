<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;

class Locale
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
     app()->setlocale(empty($request->header('Accept-Language')) ? app()->getLocale() : explode("-", $request->header('Accept-Language'))[0]);
        return $next($request);
    }
}
