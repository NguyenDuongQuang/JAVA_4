<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/6/2023
  Time: 4:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<div class="alert alert-danger">${ errorMessage }</div>
<form method="post" action="/SP23B2_SOF3011_IT17311_war_exploded/login">
    <div class="mt-3">
        <label>Mã</label>
        <input type="text" name="ma" class="form-control" />
    </div>
    <div class="mt-3">
        <label>Mật khẩu</label>
        <input type="password" name="matKhau" class="form-control" />
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>
