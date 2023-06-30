
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Chi Tiết SP</title>
</head>

<body>
<link rel="stylesheet" href="/SP23B2_SOF3011_IT17308_war_exploded/css/bootstrap.min.css"/>
<div class="col-8 offset-2 bg-light">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/update?id=${ctsp.id}" name="frmCheck"
    >
        <div class="row mt-3">
            <div class="col-6">
                <label>ID SP</label>
                <select name="idSP" class="form-select">
                    <c:forEach items="${sp}" var="sp">
                        <option ${ctsp.sanPham.id == sp.id? "selected" :""} value="${sp.id}" >${sp.ten} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>ID nsx</label>
                <select name="idNSX" class="form-select">
                    <c:forEach items="${nsx}" var="nsx">
                        <option value="${nsx.id}" ${ctsp.nsx.id == nsx.id ? "selected" : ""}>${nsx.ten} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>ID DSP</label>
                <select name="idDSP" class="form-select">
                    <c:forEach items="${dsp}" var="dsp">
                        <option value="${dsp.id}" ${ctsp.dongSp.id == dsp.id ? "selected" : ""}>${dsp.ten} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>ID MS</label>
                <select name="idMS" class="form-select">
                    <c:forEach items="${ms}" var="ms">
                        <option value="${ms.id}" ${ctsp.mauSac.id == ms.id ? "selected" : ""}>${ms.ten} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Năm BH</label>
                <input type="text" name="namBH" class="form-control"  value="${ ctsp.namBh }"  />
            </div>
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="moTa" class="form-control" value="${ ctsp.moTa }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Số Lượng Tồn</label>
                <input type="text" name="soLuongTon" class="form-control" value="${ ctsp.soLuongTon }"/>
            </div>
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="text" name="giaNhap" class="form-control" value="${ ctsp.giaNhap }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá bán</label>
                <input type="text" name="giaBan" class="form-control" value="${ ctsp.giaBan }"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <p id="cma"></p>
                <button type="submit" class="btn btn-primary">Sửa</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
</body>
</html>
