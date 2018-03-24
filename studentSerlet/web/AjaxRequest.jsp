<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/3/4
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="bb" onclick="goTo()">寻找</button>
<div id="dd"></div>
</body>
</html>
<script>
    var xmlHttpRequest;
    var dd = document.getElementById("dd");
    if(window.XMLHttpRequest)
    {
        xmlHttpRequest = new XMLHttpRequest();
    }else{
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlHttpRequest.onreadystatechange = function () {
        if (xmlHttpRequest.status==200&&xmlHttpRequest.readyState==4)
        {
            var requestText = xmlHttpRequest.responseText;
            dd.innerHTML=requestText;
        }
        console.log(xmlHttpRequest.status);
        console.log(xmlHttpRequest.responseText);
    }
    function goTo() {
        xmlHttpRequest.open("post","/AjaxRequestServlet",true);
        xmlHttpRequest.send();
    }
</script>
