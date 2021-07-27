<%@ page import="br.alura.servlet.model.User" %>
<%@ page import="java.util.UUID" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello World</title>


</head>
<body>
<h1>
    Hello World
</h1>
<h2>
    <%
        User user = User.builder().id(UUID.randomUUID().toString()).name("sssssss").build();

    %>
    <c:out value="${user.getId()}" default="Something"></c:out>

</h2>

<h3>
    <%=user.getId()%>
</h3>
<h4>

    <a href='<c:url value="form-post" />'>Form-post</a>
</h4>
</body>
</html>