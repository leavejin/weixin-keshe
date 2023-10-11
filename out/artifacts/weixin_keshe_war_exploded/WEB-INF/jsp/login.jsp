<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<h1>登录页面</h1>
<hr>

<body>
<form action="${pageContext.request.contextPath}/loginJudge">
    用户名：<input type="text" name="number"> <br>
    密码：<input type="password" name="password"> <br>
    <input type="hidden" name="sf" value="${sessionScope.sf}"> <br>
    <input type="submit" value="提交">
</form>
<a>忘记密码</a>
<a>立即注册</a>
</body>
</html>
