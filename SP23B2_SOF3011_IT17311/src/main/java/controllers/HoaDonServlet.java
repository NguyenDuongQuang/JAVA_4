package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.HoaDonRepositry;
import view_model.QLHoaDon;

import java.io.IOException;

@WebServlet({
        "/Hoa-Don/index",    // GET
        "/Hoa-Don/create",   // GET
        "/Hoa-Don/edit",     // GET
        "/Hoa-Don/delete",   // GET
        "/Hoa-Don/store",    // POST
        "/Hoa-Don/update",   // POST
})

public class HoaDonServlet extends HttpServlet {
    private HoaDonRepositry hdRepo;

    public HoaDonServlet() {
        this.hdRepo = new HoaDonRepositry();
        this.hdRepo.insert(new QLHoaDon("PH1", "12/12/2021", "13/12/2021", "14/12/2021", "15/12/2021", "đang giao", "Dương", "thanh", "123456789"));
        this.hdRepo.insert(new QLHoaDon("PH1", "16/12/2021", "17/12/2021", "18/12/2021", "19/12/2021", "đang giao", "Tuấn", "thanh1", "1234567890"));
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
        QLHoaDon hd = this.hdRepo.findByMa(ma);
        request.setAttribute("hd", hd);
        request.getRequestDispatcher("/views/Hoa_Don/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon hd = this.hdRepo.findByMa(ma);
        this.hdRepo.delete(hd);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Hoa-Don/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachHD", this.hdRepo.findAll());
        request.setAttribute("views","/views/Hoa_Don/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Hoa_Don/create.jsp")
                .forward(request, response);
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Hoa-Don/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ngay_tao = request.getParameter("ngay_tao");
        String ngay_TT = request.getParameter("ngay_TT");
        String ngay_ship = request.getParameter("ngay_ship");
        String ngay_nhan = request.getParameter("ngay_nhan");
        String tinh_trang = request.getParameter("tinh_trang");
        String tenNN = request.getParameter("tenNN");
        String dia_chi = request.getParameter("dia_chi");
        String sdt = request.getParameter("sdt");

        QLHoaDon hd = new QLHoaDon(ma, ngay_tao, ngay_TT, ngay_ship, ngay_nhan, tinh_trang, tenNN, dia_chi, sdt);
        this.hdRepo.insert(hd);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Hoa-Don/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLHoaDon hd = new QLHoaDon();
            BeanUtils.populate(hd, request.getParameterMap());
            this.hdRepo.update(hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Hoa-Don/index");
    }
}
