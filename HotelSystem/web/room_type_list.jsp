<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.coder.entity.RoomType" %><%--
  Created by IntelliJ IDEA.
  User: 86198
  Date: 2025/1/5
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/web.css">
</head>
<body>
<div class="container">
    <div class="title">酒店管理系统-房型管理</div>
    <a href="room_type_save.jsp">新增</a>
    <a href="javascript:;" id="deleteCheck">删除</a>
    <form action="RoomTypeServlet?flag=deleteCheck" method="post" id="f">
        <table class="table table-striped table-borderd table-hover table-condensed">
            <tr>
                <td><input type="checkbox" id="checkAll"></td>
                <td>序号</td>
                <td>房型</td>
                <td>价格</td>
                <td>押金</td>
                <td>床位数</td>
                <td>备注</td>
                <td>操作指令</td>
            </tr>
            <c:forEach items="${list}" var="roomType" varStatus="vs">
            <tr>
                <td><input type="checkbox" name="ids" value="${roomType.id}"></td>
                <td>${vs.count}</td>
                <td>${roomType.type}</td>
                <td>${roomType.price}</td>
                <td>${roomType.deposit}</td>
                <td>${roomType.bednum}</td>
                <td>${roomType.remark}</td>
                <td><a href="javascript:;" onclick="del(${roomType.id})">删除</a>
                    <a href="RoomTypeServlet?flag=preEdit&id=${roomType.id}">修改</a></td>
            </tr>
            </c:forEach>

    </form>
        <script>
            function del(id){
                if (confirm("确定删除吗")){
                    location.href = "RoomTypeServlet?flag=delete&id="+id;
                }
            }
        </script>
        <script src="assets/js/jquery-3.6.4.min.js"></script>
        <script>
            $(function(){
                $("#checkAll").click(function (){
                    let f = $(this).prop("checked")
                    $("[type = 'checkbox']").prop("checked",f)
                })
                $("#deleteCheck").click(function (){
                    if (confirm("确认删除选中的数据吗")){
                        $("#f").submit();
                    }
                })
            })
        </script>
    </table>
</div>
</body>
</html>
