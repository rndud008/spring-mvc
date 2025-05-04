<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Form - FrontController</title>
</head>
<body>
<h1>Register Form (FrontController)</h1>
<form action="/front-controller/members/save" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit">Register</button>
</form>
</body>
</html>