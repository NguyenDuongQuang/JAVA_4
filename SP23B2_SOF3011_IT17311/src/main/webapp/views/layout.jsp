<%-- Created by IntelliJ IDEA. User: tiennh Date: 3/9/23 Time: 15:29 To change
this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <link
      rel="stylesheet"
      href="/SP23B2_SOF3011_IT17311_war_exploded/css/bootstrap.min.css"
    />
    <style>
      .nav-item > .nav-link {
        color: #343a40;
        font-family: "Arial Narrow";
        font-size: 20px;
        font-weight: bold;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">IT17311</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#"
                >Trang chủ</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/khach-hang/index"
                >Khách hàng</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Chi-tiet-SP/index"
                >Chi tiết SP</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Chuc-Vu/index"
                >Chức Vụ</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Cua-Hang/index"
                >Cửa hàng</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/DongSP/index"
                >Dòng SP</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/index"
                >Màu Sắc</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Nhan-Vien/index"
                >Nhân Viên</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/NSX/index"
                >NSX</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/San-Pham/index"
                >Sản phẩm</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Hoa-Don/index"
                >Hóa đơn</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/index"
                >Giỏ hàng</a
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="row mt-10" style="min-height: 500px; text-align: center">
      <div class="col-12">
        <jsp:include page="${ views }"></jsp:include>
      </div>
    </div>

    <div class="row m-0 mt-10 bg-dark text-white">
      <div class="row mt-3">
        <div class="col-6">
          <h5>Cao đẳng FPT Polytechnic</h5>
          <h5>SP23B2_SOF3011_IT17311</h5>
        </div>
        <div class="col-6">
          <h5>Tên sinh viên: Lê Văn Dương</h5>
          <h5>Mã sinh viên: PH23089</h5>
        </div>
      </div>
    </div>
    <script src="/SP23B2_SOF3011_IT17311_war_exploded/js/bootstrap.min.js"></script>
  </body>
</html>
