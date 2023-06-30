package controller.admin;

import DomainModel.ChiTietSp;
import DomainModel.KhachHang;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChitietSPRepository;
import repositories.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet({
        "/khach_hang/index",
        "/khach_hang/create",
        "/khach_hang/store",
        "/khach_hang/edit",
        "/khach_hang/update",
        "/khach_hang/delete",
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
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
        KhachHang domainModelKH = this.khRepo.findByMa(ma);
        request.setAttribute("kh", domainModelKH);
        request.setAttribute("view", "/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach", this.khRepo.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainModelKH = this.khRepo.findByMa(ma);
        if (domainModelKH == null) {
            System.out.println("Không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.khRepo.delete(domainModelKH);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/khach_hang/index");
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/khach_hang/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");

        KhachHang khachHang = new KhachHangRepository().findByMa(ma);

        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String quocGia = request.getParameter("quocGia");
        String thanhPho = request.getParameter("thanhPho");

        new KhachHangRepository().update(KhachHang.builder()
                .id(khachHang.getId())
                .ma(ma)
                .ho(ho)
                .tenDem(tenDem)
                .ten(ten)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .matKhau(matKhau)
                .quocGia(quocGia)
                .thanhPho(thanhPho)
                .build());

        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/khach_hang/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String quocGia = request.getParameter("quocGia");
        String thanhPho = request.getParameter("thanhPho");

        new KhachHangRepository().insert(KhachHang.builder()
                .ma(ma)
                .ho(ho)
                .tenDem(tenDem)
                .ten(ten)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .matKhau(matKhau)
                .quocGia(quocGia)
                .thanhPho(thanhPho)
                .build());
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/khach_hang/index");
    }

}