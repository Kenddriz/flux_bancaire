<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Versement extends Model
{
	public $incrementing = false;

    protected $dates = [
        'created_at',
        'updated_at'
    ];
    protected $casts = [
        'created_at' => 'datetime:d-m-Y à H:m:s',
        'updated_at' => 'datetime:d-m-Y à H:m:s',
    ];
    protected $fillable = [
        'id', 'client_id', 'montant_versement'
    ];

    public function client() {
    	return $this->belongsTo('App\Models\Client');
    }
}
