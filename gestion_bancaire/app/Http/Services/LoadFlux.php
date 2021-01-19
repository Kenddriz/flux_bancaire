<?php 
namespace App\Http\Services;

/**
 * 
 */
class LoadFlux
{
	
	public static function flux($year="") {

        return [
            "versements" => function($query) use ($year){
                $query->whereYear('created_at', '=', $year);
                $query->orderBy('updated_at', 'desc');
            },
            "retraits" => function($query) use ($year){
                $query->whereYear('created_at', '=', $year);
                $query->orderBy('updated_at', 'desc');
            },
            "transferts" => function($query) use ($year){
                $query->whereYear('created_at', '=', $year);
                $query->orderBy('created_at', 'desc');
            }

        ];
	}
}
?>