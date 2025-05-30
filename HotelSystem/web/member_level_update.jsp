<%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2025/1/14
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        酒店管理系统-会员等级管理
    </div>

    <form action="MemberLevelServlet?flag=update" method="post">
        <div class="form-group">
            <label for="level">等级名称</label>
            <input type="text" name="level" value="${level.level}"
                   class="form-control" id="level" placeholder="请填写等级名称">
        </div>
        <div class="form-group">
            <label for="low">等级低值</label>
            <input type="number" name="low" value="${level.low}"
                   class="form-control" id="low" placeholder="请填写等级低值">
        </div>
        <div class="form-group">
            <label for="high">等级高值</label>
            <input type="number" name="high" value="${level.high}"
                   class="form-control" id="high" placeholder="请填写等级高值">
        </div>
        <div class="form-group">
            <label for="discount">等级折扣</label>
            <input type="number" name="discount" value="${level.discount}"
                   class="form-control" id="discount" placeholder="请填写等级折扣">
        </div>
        <input type="hidden" name="id" value="${level.id}">
        <button type="submit" class="btn btn-primary">提交</button>
        <button type="reset" class="btn btn-warning">重置</button>
    </form>
</div>
</body>
</html>
