<%@ page import="java.util.*" %>
<%@ page import="com.biggw.day35.el.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());


        request.setAttribute("u",user);


        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        <%-- 一般我们叫什么变量，就设置什么键，方便查找 --%>
        request.setAttribute("list",list);


        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);

        request.setAttribute("map",map);

    %>

<h3>el获取对象中的值</h3>
${requestScope.u}<br>

<%--
    * 通过的是对象的属性来获取
        * setter或getter方法，去掉set或get，在将剩余部分，首字母变为小写。
        * setName --> Name --> name
--%>


    <%-- 获取对象中的属性 --%>
    ${requestScope.u.name}<br>
    ${u}                      <%-- 从小到大，从域中，查找有没有 u --%>
    ${u.age}<br>
    ${u.birthday}<br>
    ${u.birthday.month}<br>

    ${u.birStr}<br>      <%-- 逻辑视图 --%>


    <%-- 获取集合中元素--%>
    <h3>el获取List值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list[10]}<br>

    ${list[2].name}   <%-- 调用 getName() 方法 --%>

    <h3>el获取Map值</h3>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}  <%-- 获取user对象的name --%>

</body>
</html>
