<%--
  Created by IntelliJ IDEA.
  User: Maizing
  Date: 2023-10-08
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>请选择正确身份登录</p>
  <a href="${pageContext.request.contextPath}/jumplogin?sf=user">用户</a>
  <a href="${pageContext.request.contextPath}/jumplogin?sf=courier">快递员</a>
  <a href="${pageContext.request.contextPath}/jumplogin?sf=siteAdmin">网点管理员</a>
  <a href="${pageContext.request.contextPath}/jumplogin?sf=admin">管理员</a>
  </body>
</html>
