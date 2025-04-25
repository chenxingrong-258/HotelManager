<%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2025/1/13
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><h3>在线支持系统</h3></div>
<form action="CheckServlet" method="post">
    <div>
        故障系统:
        <select name="os">
            <option value="win10">win10</option>
            <option value="win11">win11</option>
            <option value="win8">win8</option>
        </select>
    </div>
    <div>
        故障软件:
        <select name="soft">
            <option value="word">word</option>
            <option value="excel">excel</option>
            <option value="ppt">ppt</option>
        </select>
    </div>
    <div>
        电子邮箱:<input type="email" name="email">
    </div>
    <div>
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>
