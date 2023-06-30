package controller.admin;

import DomainModel.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.KhachHangRepository;
import repositories.NhanVienRepository;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/nhan_vien/index",
        "/nhan_vien/create",
        "/nhan_vien/store",
        "/nhan_vien/edit",
        "/nhan_vien/update",
        "/nhan_vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        List<CuaHang> lch = new CuaHangRepository().findAll();
        request.setAttribute("ch", lch);
        List<ChucVu> lcv = new ChucVuRepository().findAll();
        request.setAttribute("cv", lcv);
        NhanVien qlnv = this.nvRepo.findByMa(ma);
        request.setAttribute("nv", qlnv);
        request.setAttribute("view", "/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }


    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach", this.nvRepo.findAll());
        request.setAttribute("view", "/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        List<CuaHang> lch = new CuaHangRepository().findAll();
        request.setAttribute("ch", lch);
        List<ChucVu> lcv = new ChucVuRepository().findAll();
        request.setAttribute("cv", lcv);
        request.setAttribute("view", "/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien qlnv = this.nvRepo.findByMa(ma);
        if (qlnv == null) {
            System.out.println("Không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.nvRepo.delete(qlnv);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nhan_vien/index");
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nhan_vien/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien hanVien = new NhanVienRepository().findByMa(ma);
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String cuaHang = request.getParameter("cuaHang");
        String chucVu = request.getParameter("chucVu");
        String trangThai = request.getParameter("trangThai");
        String gioiTinh = request.getParameter("gioiTinh");


        new NhanVienRepository().update(NhanVien.builder()
                .id(hanVien.getId())
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .matKhau(matKhau)
                .cuaHang(CuaHang.builder().id(cuaHang).build())
                .chucVu((ChucVu.builder().id(chucVu).build()))
                .trangThai(Integer.parseInt(trangThai))
                .gioiTinh(gioiTinh)
                .build());

        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nhan_vien/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String cuaHang = request.getParameter("cuaHang");
        String chucVu = request.getParameter("chucVu");
        String trangThai = request.getParameter("trangThai");
        String gioiTinh = request.getParameter("gioiTinh");

        new NhanVienRepository().insert(NhanVien.builder()
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .matKhau(matKhau)
                .cuaHang(CuaHang.builder().id(cuaHang).build())
                .chucVu((ChucVu.builder().id(chucVu).build()))
                .trangThai(Integer.parseInt(trangThai))
                .gioiTinh(gioiTinh)
                .build());
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nhan_vien/index");

    }

}
