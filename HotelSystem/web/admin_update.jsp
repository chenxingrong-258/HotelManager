<%@ page import="com.coder.entity.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2025/1/10
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>酒店管理系统</title>
  <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/web.css">
</head>
<body>

<div class="container">
  <div class="title">
    酒店管理系统-用户管理
  </div>

  <form action="AdminServlet?flag=update" method="post">
    <div class="form-group">
      <label for="type">用户姓名</label>
      <input type="text" name="name" required value="${admin.name}"
             class="form-control" id="type" placeholder="请填写用户姓名">
    </div>
    <input type="hidden" name="id" value="${admin.id}">
    <button type="submit" class="btn btn-primary">提交</button>
    <button type="reset" class="btn btn-warning">重置</button>
  </form>
</div>
</body>