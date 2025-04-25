<%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2024/12/28
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>酒店管理系统</title>
  <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>
<div class="user">
  <c:if test="${empty admin}">
    <a href="login_ajax.jsp">登入</a>
  </c:if>
  <c:if test="${!empty admin}">
    欢迎：${admin.name}[<a href="AdminServlet?flag=logout">登出</a>]
  </c:if>
</div>
<div class="title">酒店管理系统</div>
<div class="container">
  <div class="item">
    <img src="assets/img/类型.png">
    <div>
      <a href="RoomTypeServlet?flag=selectList">
        房型管理
      </a>
    </div>
  </div>
  <div class="item">
    <img src="assets/img/类型.png">
    <div>
      <a href="GoodsTypeServlet?flag=selectList">
        商品分类
      </a>
    </div>
  </div>
  <div class="item">
    <img src="assets/img/会员管理.png">
    <div>
      <a href="MemberLevelServlet?flag=selectList">
        会员管理
      </a>
    </div>
  </div>
  <div class="item">
    <img src="assets/img/用户管理.png">
    <div>
      <a href="AdminServlet?flag=selectList">
        用户管理
      </a>
    </div>
  </div>
  <div class="item">
    <img src="assets/img/房间管理.png">
    <div>
      <a href="RoomInfoServlet?flag=selectList">
        房间管理
      </a>
    </div>
  </div>
</div>
</body>
</html>
