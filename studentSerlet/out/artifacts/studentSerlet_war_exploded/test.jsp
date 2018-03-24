<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/2/24
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String str = request.getParameter("lastName");
    System.out.println(str);
  %>
  Student Registration Form
  <form action="#" method="GET">
    Last Name : <input type="text" name="lastName"> First Name : <input type="text" name="firstName"> MI<input type="text" name="mi" size="1"><br>
    Gender
    <input type="ra
    dio" name="gender" value="M" checked>Male
    <input type="radio" name="gender" value="F">Female<br>
    Major<select name="major">
    <option value="CS">Computer Science</option>
    <option value="Math">Mathematics</option>
    <option>English</option>
    <option>Chinese</option>
  </select>
    Minor<select name="minor" size="2" multiple>
    <option>mathematics</option>
    <option>English</option>
    <option>Chinese</option>
  </select><br>
    Hobby:
    <input type="checkbox" name="tennis">Tennis
    <input type="checkbox" name="golf">Golf
    <input type="checkbox" name="pingPong" checked>ping Pong<br>
    Remarks:
    <textarea rows="3" cols="56" name="remarks"></textarea>
    <input type="submit" value="submit">
    <input type="reset" value="reset">
    </select>
  </form>
  </body>
</html>
