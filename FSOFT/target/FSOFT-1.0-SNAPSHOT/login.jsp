<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/30/2023
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<div class="title">
    <h1>Login</h1>
</div>
<div class="form-login">
    <form action="checkLog" method="post">
        <div class="input">
            <label>User Name</label>
            <input type="text" name="username" style="height: 20px" placeholder="User Name"/> <br/>
        </div>

        <div class="input">
            <label>Password</label>
            <input type="text" name="password" style="height: 20px" placeholder="Password"/> <br/>
        </div>

        <input class="submit" type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
