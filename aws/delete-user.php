<?php
include_once "dbconf.php";

echo "Processing...";
$msg = "Unable to process request";
try {
    $id = $_GET["id"];
    if($PDO !=null && $id !=null){
            $sql = "DELETE  FROM user WHERE id = :id";
            $stmt = $PDO->prepare($sql);
            
            $stmt->bindParam(":id", $id);
            
            $stmt->execute();

            $msg = "Success";
    }
} catch (Exception $th) {
    $msg = $th->getMessage();
    //throw $th;
}


header( "refresh:0;url=/index.php?msg=".$msg);

