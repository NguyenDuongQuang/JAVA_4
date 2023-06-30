<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/13/2023
  Time: 7:18 PM
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
      action="/SP23B2_SOF3011_IT17311_war_exploded/Nhan-Vien/store">
    <div class="row mt-3">
        <div class="col-6">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" />
        </div>
        <div class="col-6">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control" />
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Tên đệm</label>
            <input type="text" name="tenDem" class="form-control" />
        </div>
        <div class="col-6">
            <label>Họ</label>
            <input type="text" name="ho" class="form-control" />
        </div>
    </div>
    <div class="col-6">
        <div class="gioiTinh">
            <label>Giới tính</label>
            <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1" value="Nam" checked = "checked" >
            <label class="form-check-label" for="inlineRadio1">Nam</label>
            <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2" value="Nữ">
            <label class="form-check-label" for="inlineRadio2">Nữ</label>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Ngày sinh</label>
            <input type="date" name="ngaySinh" class="form-control" />
        </div>
        <div class="col-6">
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control" />
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>SDT</label>
            <input type="number" name="sdt" class="form-control" />
        </div>
        <div class="col-6">
            <label>Mật khẩu</label>
            <input type="password" name="matKhau" class="form-control" />
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Cửa Hàng</label>
            <input type="text" name="idCH" class="form-control" />
        </div>
        <div class="col-6">
            <label>Chức Vụ</label>
            <input type="text" name="idCV" class="form-control" />
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6">
            <label>Trạng thái</label>
            <input type="tel" name="trangThai" class="form-control" />
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
