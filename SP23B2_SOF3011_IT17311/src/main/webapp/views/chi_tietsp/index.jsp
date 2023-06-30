
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="/SP23B2_SOF3011_IT17311_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2 mt-5 table-responsive">
    <h1 style="text-align: center">Quản lí chi tiết sản phẩm</h1>
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>


    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <td>Sản Phẩm</td>
            <td>Nhà Sản Xuất</td>
            <td>Màu Sắc</td>
            <td>Dòng Sản Phẩm</td>
            <td>Năm BH</td>
            <td>Mô tả</td>
            <td>Số Lượng Tồn</td>
            <td>Giá Nhập</td>
            <td>Giá Bán</td>
            <td>Chức năng</td>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${danhSach}" var="ctsp">
            <tr>
                <td>${ctsp.sanPham.ten}</td>
                <td>${ctsp.nsx.ten}</td>
                <td>${ctsp.mauSac.ten}</td>
                <td>${ctsp.dongSp.ten}</td>
                <td>${ctsp.namBh}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>

                <td>
                    <a href="/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/edit?id=${ctsp.id}" class="btn btn-primary">Cập nhật</a>

                    <a href="/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/delete?id=${ctsp.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
<script src="/SP23B2_SOF3011_IT17311_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
