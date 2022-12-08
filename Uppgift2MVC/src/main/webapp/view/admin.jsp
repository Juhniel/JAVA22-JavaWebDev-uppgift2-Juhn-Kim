<%@ page import="controller.LoginServlet" %>
<%@ page import="model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: juhns
  Date: 2022-12-06
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>

<h1>Welcome ${online.getUserName()}</h1>
<p>You are successfully logged in!</p>
<hr>
<p>${error}</p>
<p>${favouriteMovie}</p>

<form action="${pageContext.request.contextPath}/favourite" method="get">
    <label for="favouriteMovie">Favourite movie </label>
    <input type="text" id="favouriteMovie" name="favouriteMovie">
    <button type="submit">Send</button>
</form>
<p>Press this button to log out:</p>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit">Log out</button>
</form>

</body>
</html>
