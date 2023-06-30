<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/23/2023
  Time: 1:22 AM
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
          action="/SP23B2_SOF3011_IT17311_war_exploded/Chi-Tiet-SP/update?ma=${ct.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ct.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Năm BH</label>
                <input type="text" name="namBh" class="form-control" value="${ct.namBh}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="moTa" class="form-control" value="${ct.moTa}"/>
            </div>
            <div class="col-6">
                <label>Số lượng tồn</label>
                <input type="text" name="slt" class="form-control" value="${ct.slt}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="text" name="giaNhap" class="form-control" value="${ct.giaNhap}"/>
            </div>
            <div class="col-6">
                <label>Giá bán</label>
                <input type="text" name="giaBan" class="form-control" value="${ct.giaBan}"/>
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
