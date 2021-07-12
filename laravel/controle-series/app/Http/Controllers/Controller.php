<?php

namespace App\Http\Controllers;

use http\Client\Response;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;

class Controller extends BaseController
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;

    public function response($data = null, int $status = 500, string $message = null, $errors = [], array $header = [])
    {
        return \response([
            "data" => $data,
            "message" => $message,
            "errors" => $errors
        ], $status, $header);
    }

    public function ok($data = null, string $message = null, $errors = [], array $header = []){
        return $this->response($data, 200, $message,$errors,$header);
    }
    public function notFound($data = null, string $message = null, $errors = [], array $header = []){
        return $this->response($data, 404, $message,$errors,$header);
    }
    public function serverError($data = null, string $message = null, $errors = [], array $header = []){
        return $this->response($data, 500, $message,$errors,$header);
    }
    public function badRequest($data = null, string $message = null, $errors = [], array $header = []){
        return $this->response($data, 400, $message,$errors,$header);
    }
    public function notAcceptable($data = null, string $message = null, $errors = [], array $header = []){
        return $this->response($data, 406, $message,$errors,$header);
    }
}
