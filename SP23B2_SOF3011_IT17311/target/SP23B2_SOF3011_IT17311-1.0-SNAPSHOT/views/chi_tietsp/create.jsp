
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi Tiết SP</title>
</head>
<script>
    function check(){
        var idSP = document.frmCheck.idSP.value;
        var idNSX = document.frmCheck.idNSX.value;
        var idMS = document.frmCheck.idMS.value;
        var idDSP = document.frmCheck.idDSP.value;
        var namBH = document.frmCheck.namBH.value;
        var moTa = document.frmCheck.moTa.value;
        var soLuongTon = document.frmCheck.soLuongTon.value;
        var giaNhap = document.frmCheck.giaNhap.value;
        var giaBan = document.frmCheck.giaBan.value;
        if (idSP == "") {
            document.getElementById("cma").innerHTML = " Mã không được để trống"
            return false;
        } else if(idNSX== ""){
            document.getElementById("cma").innerHTML = " Tên không được để trống"
            return false;
        } else if(idMS== ""){
            document.getElementById("cma").innerHTML = " Địa Chỉ không được để trống"
            return false;
        } else if(idDSP== ""){
            document.getElementById("cma").innerHTML = " Mật Khẩu không được để trống"
            return false;
        } else if(namBH== ""){
            document.getElementById("cma").innerHTML = " Năm BH không được để trống"
            return false;
        }else if(moTa== ""){
            document.getElementById("cma").innerHTML = " Mô tả không được để trống"
            return false;
        }else if(soLuongTon== ""){
            document.getElementById("cma").innerHTML = " Số lượng không được để trống"
            return false;
        }else if(giaBan== ""){
            document.getElementById("cma").innerHTML = " Giá bán không được để trống"
            return false;
        }else if(giaNhap== ""){
            document.getElementById("cma").innerHTML = " Giá nhập không được để trống"
            return false;
        }
        else {
            return true;
        }
    }
</script>
<body>
<link rel="stylesheet" href="/SP23B2_SOF3011_IT17311_war_exploded/css/bootstrap.min.css" />
<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/store" name="frmCheck" onsubmit="return check()" >
        <div class="row mt-3">
            <div class="col-6">
                <label>ID SP</label>
                <select name="idSP" class="form-select">
                    <c:forEach items="${sp}" var="sp">
                        <option value="${sp.id}">${sp.ten} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>ID nsx</label>
                <select name="idNSX" class="form-select">
                    <c:forEach items="${nsx}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>ID DSP</label>
                <select name="idDSP" class="form-select">
                    <c:forEach items="${dsp}" var="dsp">
                        <option value="${dsp.id}">${dsp.ten} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>ID MS</label>
                <select name="idMS" class="form-select">
                    <c:forEach items="${ms}" var="ms">
                        <option value="${ms.id}">${ms.ten} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Năm BH</label>
                <input type="text" name="namBH" class="form-control" />
            </div>
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="moTa" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Số Lượng Tồn</label>
                <input type="text" name="soLuongTon" class="form-control" />
            </div>
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="text" name="giaNhap" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá bán</label>
                <input type="text" name="giaBan" class="form-control" />
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <p id="cma"></p>
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
</body>
</html>
