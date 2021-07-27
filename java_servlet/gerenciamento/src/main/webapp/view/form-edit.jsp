<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.alura.servlet.dao.EmpresaDao" %>
<%@ page import="br.alura.servlet.model.Empresa" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/form-post" var="urlPost"/>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Form Post</title>
</head>
<body>
<h1>Form Edit</h1>
<form action="" method="POST">
    Nome: <input type="text" name="nome" value="${empresa.getNome()}">
    <button type="send">Update</button>
    <hr>
    Data: <span>
    <fmt:formatDate value="${empresa.getData()}" pattern="yyyy-MM-dd HH:mm:ss"/>
</span>
</form>

</body>
</html>