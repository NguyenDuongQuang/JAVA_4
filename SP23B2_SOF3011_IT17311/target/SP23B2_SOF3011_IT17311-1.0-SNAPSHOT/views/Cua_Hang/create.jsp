<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/13/2023
  Time: 11:08 PM
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
          action="/SP23B2_SOF3011_IT17311_war_exploded/Cua-Hang/store">
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
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" />
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="ha_noi">Hà Nội</option>
                    <option value="new_york">New York</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vi">Việt Nam</option>
                    <option value="us">Mỹ</option>
                </select>
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
