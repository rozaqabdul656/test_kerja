<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\User;
use Illuminate\Support\Facades\Auth;
use Validator;

use Illuminate\Support\Facades\Hash;

use App\register;
class apilog extends Controller
{
    public $successStatus = 200;

    public function login(){
        if(Auth::attempt(['email' => request('email'), 'password' => request('password')])){
           $name= Auth::user()->name;
            return response()->json(['succes'],$this->successStatus);
        }
        else{
            return response()->json(['error'], 401);
        }
   	}

}
