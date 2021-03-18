<?php
    $DB_DBNAME =  "db";
    $DB_URL =  "mysql:host=database-01.chbok4u6ltzv.us-east-2.rds.amazonaws.com;dbname=".$DB_DBNAME;
    $DB_USER =  "admin";
    $DB_PASS =  "includestdioh";

    try{
        $PDO = new PDO($DB_URL, $DB_USER, $DB_PASS);
    }catch (Exception $e){  
        echo 'Erro ao conectar com o MySQL: ' . $e->getMessage();
    }

?>