<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Transfert extends Model
{
	public $incrementing = false;
    protected $keyType = "string";

    protected $dates = [
        'created_at',
        'updated_at'
    ];
    protected $casts = [
        'created_at' => 'datetime:d-m-Y à H:m:s',
        'updated_at' => 'datetime:d-m-Y à H:m:s',
    ];
    protected $fillable = [
        'id', 'sender_id','receiver_id', 'montant_transfert'
    ];

    public function client() {
    	return $this->belongsTo('App\Models\Client', "sender_id");
    }
}
