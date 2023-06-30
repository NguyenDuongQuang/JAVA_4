<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/23/2023
  Time: 6:51 AM
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
          action="/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Ngày Tạo</label>
                <input type="date" name="ngayTao" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày thanh toán</label>
                <input type="date" name="ngayTT" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên người nhận</label>
                <input type="text" name="tenNN" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" />
            </div>
            <div class="col-6">
                <label>SĐT</label>
                <input type="text" name="sdt" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tình trạng</label>
                <input type="text" name="tinhTrang" class="form-control" />
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
