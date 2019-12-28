<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/9
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="login" method="post">
    <input type="text" name="userName" placeholder="输入用户名" />
    <br/>
    <input type="password" name="password" placeholder="输入密码" />
    <br />
    <input type="submit" value="登录">
    <button><a href="rigister.jsp">注册</a></button>
    <input type="reset" value="重置">
  </form>
  </body>
</html>
