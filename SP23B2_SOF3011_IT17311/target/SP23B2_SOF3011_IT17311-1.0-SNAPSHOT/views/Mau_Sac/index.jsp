<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/16/2023
  Time: 1:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/SP23B2_SOF3011_IT17311_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachMS) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachMS) != 0 }">
        <h3 style="text-align: center">Dữ liệu bảng màu sắc</h3>
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachMS }" var="ms">
                <tr>
                    <td>${ ms.ma }</td>
                    <td>${ ms.ten }</td>
                    <td>
                        <a class="btn btn-primary" href="/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/edit?ma=${ ms.ma }">Cập nhật</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/delete?ma=${ ms.ma }">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script src="/SP23B2_SOF3011_IT17311_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
