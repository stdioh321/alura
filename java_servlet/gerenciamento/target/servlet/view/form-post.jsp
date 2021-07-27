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
<h1>Form Post</h1>

<form action='${urlPost}' method="POST" id="form-post" accept-charset="utf-8">
    Name: <input type="text" name="name" id="name" placeholder="Sua empresa..." required minlength="3"/>
    <button type="submit">Send</button>

</form>
<hr>
<c:set var="now" value="<%= new java.util.Date()%>"/>
<p>Formatted Date: <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                   value="${now}"/></p>

<hr>
<ul>
    <c:forEach items="${empresas}" var="empresa">
        <li>
            <b>
                    ${empresa.getNome()}
            </b>
            <b>

                <a href='<c:url value="/form-edit" />?id=${empresa.getId()}'>Editar</a>
                <a href='<c:url value="/form-delete" />?id=${empresa.getId()}'>Remover</a>


            </b>
        </li>
    </c:forEach>


</ul>

<script>
    let form = document.querySelector("#form-post");
    form.addEventListener("submit", (event) => {
        var fieldName = event.target.name;
        if (!fieldName || !fieldName.value || fieldName.value.length < 3) {
            event.preventDefault();
            return;
        }

    });
</script>
</body>
</html>