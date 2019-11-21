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

    <form action="/day34/loginServlet" method="post">
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
            <%=login_error == null ? "" : login_error%>
        </p>
        <p>
            <%=code_error == null ? "" : code_error %>
        </p>
    </form>

</body>
</html>
