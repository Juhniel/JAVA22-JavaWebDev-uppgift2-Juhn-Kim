<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <h1>LOGIN</h1>
    <hr>
    Username: <input type="text" name="username" id="username"><br>
    Password: <input type="password" name="password" id="password"><br>
    <button type="submit">Log in</button>
</form>
<p>${error}</p>
</body>
</html>