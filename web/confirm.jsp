<%@ page import="aaa.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/2/26
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = (User) session.getAttribute("user");%>
<form action="RegistrationWithSession" method="post">
    name:<%=user.getName()%><br>
    password:<%=user.getPassword()%>
    <button type="submit">提交</button>
</form>
</body>
</html>
