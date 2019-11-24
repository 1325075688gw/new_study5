<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/23 0023
  Time: 下午 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>首页</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
  </head>


  <body>

  <div >${user.name},欢迎您</div>
  <div align="center">
    <a
            href="${pageContext.request.contextPath}/findUserByPageServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
  </div>

  </body>
</html>
