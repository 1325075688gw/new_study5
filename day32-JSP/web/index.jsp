<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/20 0020
  Time: 下午 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
        <%
            // 这儿和service里面写法一样
            // 下面两句会打印到控制台
            System.out.println("你好，JSP！");
            System.out.println("我是kim！");
            out.print("1+3 = "+(1+3));
            out.print("anInt: "+ anInt);
        %>

        <%!
            int anInt = 5;

        %>

        <%="hello"%>
        <%=anInt%>
</body>
</html>


<%-- 浏览器显示: 1+3 = 4anInt: 5 hello --%>