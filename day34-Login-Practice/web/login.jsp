<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21 0021
  Time: 下午 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>

    <script>
        window.onload = function (ev) {
            document.getElementById("img").onclick = function (ev1) {
                this.src = "/day34/checkCodeServlet?time=" + new Date().getTime();
            }
        }

    </script>

    <style>
        p {
            color: red;
        }
    </style>

</head>
<body>

    <%-- 动态获取虚拟目录 --%>
<%--    <form action="/day34/loginServlet" method="post">--%>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post"></form>
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td>验证码:</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <img id="img" src="/day34/checkCodeServlet" alt="" name="img">
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>

        <%
            String login_error = (String) request.getAttribute("login_error");
            String code_error = (String) request.getAttribute("code_error");
        %>

        <p>
            <%--  3元表达式 --%>
            <%=login_error == null ? "" : login_error%>
        </p>
        <p>
            <%=code_error == null ? "" : code_error %>
        </p>

        <%-- 我们可以用el简化代码,如果有就显示，如果为null或者，查找不到，就显示空字符串 --%>
        ${requestScope.login_error}
        ${requestScope.code_error}



    </form>

</body>
</html>
