<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21 0021
  Time: 下午 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>服务器异常</title>
</head>
<body>

    <%
        out.print("hhhh");
        String message = exception.getMessage();
        out.print(message);
    %>

</body>
</html>
