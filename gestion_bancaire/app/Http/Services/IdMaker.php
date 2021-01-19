<?php

namespace App\Http\Services;

class IdMaker {
	public function __construct() {}

	public static function getId($table) {

		$all = '\App\Models\\'.$table;
		$all = $all::all('id');

		$newId = 1;
		$lastId = 0;

		switch ($table) {
			case 'Client':
				$id_prefix_length = 4;
				$id_prefix_position = 1;
				$id_prefix = "C";
				break;
			
			default:
				$id_prefix_length = 2;
				$id_prefix_position = 2;
				$id_prefix = chr(rand(65,90)).chr(rand(65, 90));
				break;
		}

		foreach ($all as $one) {
		    $lastId = intval(substr($one->id, $id_prefix_position));
			if($lastId != $newId) break;
			$newId++;
		}

		while(strlen($newId) <= $id_prefix_length) $newId = "0".$newId;

		return $id_prefix.$newId;
	}
}
?>
