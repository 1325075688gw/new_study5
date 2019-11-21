<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>


    <%
        //在域中存储数据
        session.setAttribute("name","李四");

        request.setAttribute("name","张三");
        session.setAttribute("age","23");

        request.setAttribute("str","");

    %>

<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}  <%-- 如果有就显示，如果为null或者，查找不到，就显示空字符串 --%>

${name}      <%-- 会打印张三，因为 request对象的域范围比session对象的域范围更小 --%>
${sessionScope.name}   <%-- 李四 -->




</body>
</html>
