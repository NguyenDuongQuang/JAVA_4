<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/23/2023
  Time: 5:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/SP23B2_SOF3011_IT17311_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17311_war_exploded/Hoa-Don/update?ma=${ hd.ma }">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ hd.ma }" disabled/>
            </div>
            <div class="col-6">
                <label>Ngày Tạo</label>
                <input type="date" name="ngay_tao" class="form-control" value="${ hd.ngay_tao }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày thanh toán</label>
                <input type="date" name="ngay_TT" class="form-control" value="${ hd.ngay_TT }"/>
            </div>
            <div class="col-6">
                <label>Ngày Ship</label>
                <input type="date" name="ngay_ship" class="form-control" value="${ hd.ngay_ship }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày nhận</label>
                <input type="date" name="ngay_nhan" class="form-control" value="${ hd.ngay_nhan }"/>
            </div>
            <div class="col-6">
                <label>Tình trạng</label>
                <input type="text" name="tinh_trang" class="form-control" value="${ hd.tinh_trang }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên người nhận</label>
                <input type="text" name="tenNN" class="form-control" value="${ hd.tenNN }"/>
            </div>
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${ hd.dia_chi }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>SĐT</label>
                <input type="text" name="sdt" class="form-control" value="${ hd.sdt }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/SP23B2_SOF3011_IT17311_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
