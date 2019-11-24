<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21 0021
  Time: 下午 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" buffer="8kb" %>
<html>
  <head>
    <title>主页面</title>
  </head>
  <body>

     <%
       List<Integer> list =  new ArrayList();
       list.add(1);
       list.add(2);
       for (Integer integer : list) {
         out.print(integer);
       }
     %>

  </body>
</html>
