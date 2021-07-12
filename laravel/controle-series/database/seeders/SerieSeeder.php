<?php

namespace Database\Seeders;

use App\Models\Serie;
use Illuminate\Database\Seeder;
use Illuminate\Support\Str;

class SerieSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
//        $s = new Serie;
//        $s->nome = "Yoshi";
//        $s->save();
        for ($i = 0; $i < 10; $i++) {

            if (Serie::count() >= 10) break;
            $s = new Serie;
            $s->nome = Str::random(10);
            $s->save();
        }
        //
    }
}
