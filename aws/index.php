<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<?php
 require_once("dbconf.php");
    
   if(isset($PDO)){
    
    $sql = "SELECT * FROM user";
    $result = $PDO->query( $sql );
    $users = $result->fetchAll();    
    
    // print_r( $users );
   }
   
   
?>

</head>
<body>
   <div id="app">
   <div class="container">
   <div class="row">
       <div class="col-12">
            <h4>
                <?php
                    echo gethostbyname($_SERVER['SERVER_NAME']);
                ?>
            </h4>
       </div>
   </div>
    <div class="row">
        <div class="col-12">
        <h1>Cadastro</h1>
        </div>
    </div>
   <div class="row my-2">
       <div class="col-12">
            <form action="/add-user.php" method="POST"> 
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="fName" class="sr-only" >Name</label>
                        <input type="text" class="form-control" id="fName" name="name" placeholder="Name" required />
                    </div>
                    <div class="form-group col-md-5">
                        <label for="fEmail" class="sr-only" >Email</label>
                        <input type="email" class="form-control" id="fEmail" name="email" placeholder="Email" required />
                    </div>
                    <div class="form-group col-md">
                        <button class="btn btn-primary btn-block" type="submit">Send</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-12 my-3 msg-wrapper d-none" >
            <div class="alert alert-info">
            
            </div>
        </div>
   </div>

    <div class="row mt-3">
        <div class="col-12">
        <table class="table table-responsive-sm">
        <thead>
        <tr>
        <th>#</th>
        <th>Name</th>
        <th>Email</th>
        <th>
            <i class='fa fa-2x fa-trash' aria-hidden='true'></i>
        </th>
        </tr>
        </thead>
        <tbody>
            <?php
                if(isset($users)){
                    foreach($users as $user){
                        echo "<tr>";
                        echo "<td>{$user['id']}</td>";
                        echo "<td>{$user['name']}</td>";
                        echo "<td>{$user['email']}</td>";
                        echo "<td><a class='text-danger' href='/delete-user.php?id={$user['id']}'><i class='fa fa-trash' aria-hidden='true'></i></a></td>";
                        echo "</tr>";
                    }
                }
            ?>
        </tbody>
    </table>
        </div>
    </div>
   </div>
   </div>
    
    
</body>
<script>
    window.onload = function(){
        var msgWrapper = document.querySelector(".msg-wrapper");
        if(msgWrapper){
            var url = new URL(location.href);
            var msg = url.searchParams.get("msg");
            if(msg){
                msgWrapper.classList.remove("d-none");
                msgWrapper.querySelector("div").innerHTML = msg;
            }
        }
    };
</script>
</html>