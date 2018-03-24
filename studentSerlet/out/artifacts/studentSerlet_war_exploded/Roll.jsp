<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/2/26
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String jsonObject = (String) request.getAttribute("jsonObject");
    %><input type="hidden" id="jsonObject" value=<%=jsonObject%>><%
%>
<form id="firstForm" action="/json" method="post">
姓名：<input type="text" class="Roll" value="111" name="name"><br>
密码: <input type="text" class="Roll" value="222" name="password"><br>
    <input type="button" value="摇奖" onclick="startRoll()">
    <input type="submit" value="停止" onclick="stopRoll()">
</form>
</body>
</html>
<script>
    var jsonObject = document.getElementById('jsonObject');
    var text = document.getElementsByClassName("Roll");
    var index=0;
    var timer;
    var jsObject = JSON.parse(jsonObject.value);
    var firstForm = document.getElementById("firstForm")
    // var resultSet = JSON.parse(jsonObject);
    function goRoll() {
           text[0].setAttribute("value",jsObject[index].name);
           // console.log(jsonObject[index].name);
           text[1].setAttribute("value",jsObject[index].password);
           index++;
           if (index>=jsObject.length)
           {
               index=0;
           }
    }
    function startRoll() {
        timer=setInterval(goRoll,100);
    }
    function stopRoll() {
        clearInterval(timer);
        // var xmlHttp = new XMLHttpRequest();
        // xmlHttp.open("post",firstForm.action);
        // xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
        // xmlHttp.send();
    }
</script>