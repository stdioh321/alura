<%--
  Created by IntelliJ IDEA.
  User: hdias
  Date: 26/07/2021
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta charset="UTF-8">


    <title>Empresa Adicionada</title>
</head>
<body>
<h1>Empresa ${empresa.getNome()} adicionada.</h1>
<h3>
    Session:
    ${sessionScope['empresa'].getNome()}
</h3>
<h4>
    <fmt:formatDate value="${empresa.getData()}" pattern="yyyy-MM-dd HH:mm:ss"/>
</h4>
<a href="/form-post">Voltar</a>
</body>
</html>
