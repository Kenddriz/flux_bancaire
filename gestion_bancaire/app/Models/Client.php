<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Client extends Model
{
    public $incrementing = false;
    public $keyType = "string";

    protected $dates = [
        'created_at',
        'updated_at'
    ];

    protected $fillable = [
        'id', 'nom', 'solde'
    ];

    protected $casts = [
        'created_at' => 'datetime:d-m-Y à H:m:s',
        'updated_at' => 'datetime:d-m-Y à H:m:s',
    ];

    public function versements() {
    	return $this->hasMany('App\Models\Versement');
    }

    public function retraits() {
    	return $this->hasMany('App\Models\Retrait');
    }

    public function transferts() {
        return $this->hasMany('App\Models\Transfert', 'sender_id');
    }
}
