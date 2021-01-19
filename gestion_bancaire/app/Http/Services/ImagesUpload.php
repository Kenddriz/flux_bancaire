<?php

namespace App\Http\Services;

class ImagesUpload
{

    public static function upload($images, $path) {

        $path = public_path('images/'.$path);
        $names = array();
        foreach($images as $image) {

            $name = microtime(true).'.'.$image->extension();
            array_push($names, $name);
            $image->move($path, $name);
        }
        return $names;
    }

    public static function remove($image) {
        $image = 'images/'.$image;
        if(is_file(public_path($image)))
            unlink(public_path($image));
    }
}
