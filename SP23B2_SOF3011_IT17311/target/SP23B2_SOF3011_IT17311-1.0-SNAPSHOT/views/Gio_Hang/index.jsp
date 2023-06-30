<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/23/2023
  Time: 6:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/SP23B2_SOF3011_IT17311_war_exploded/css/bootstrap.min.css" />
</head>
<body>
<div class="col-8 offset-2 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachGH) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachGH) != 0 }">
        <h3 style="text-align: center">Dữ liệu bảng hóa đơn</h3>
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Ngày tạo</th>
                <th>Ngày thanh toán</th>
                <th>Tên người nhận</th>
                <th>Địa chỉ</th>
                <th>SĐT</th>
                <th>Tình trạng</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachGH }" var="gh">
                <tr>
                    <td>${ gh.ma }</td>
                    <td>${ gh.ngayTao }</td>
                    <td>${ gh.ngayTT }</td>
                    <td>${ gh.tenNN }</td>
                    <td>${ gh.diaChi }</td>
                    <td>${ gh.sdt }</td>
                    <td>${ gh.tinhTrang }</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/edit?ma=${ gh.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/delete?ma=${ gh.ma }">
                            Xóa
                        </a>
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
