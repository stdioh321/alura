<?php
include_once "dbconf.php";

echo "Processing...";
$msg = "Unable to process request";
try {
    $name = $_POST["name"];
    $email = $_POST["email"];

    if($PDO !=null && $name !=null && $email !=null){
            $sql = "INSERT INTO user(name, email) VALUES(:name, :email);";
            $stmt = $PDO->prepare($sql);
            
            $stmt->bindParam(":name", $name);
            $stmt->bindParam(":email", $email);
            $stmt->execute();

            $msg = "Success";
    }
} catch (Exception $th) {
    $msg = $th->getMessage();
    //throw $th;
}


header( "refresh:0;url=/index.php?msg=".$msg);

