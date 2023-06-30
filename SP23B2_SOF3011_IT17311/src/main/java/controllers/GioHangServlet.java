package controllers;

import Domain_model.DongSP;
import Domain_model.GioHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.GioHangRepositry;
import view_model.QLGioHang;

import java.io.IOException;

@WebServlet({
        "/Gio-Hang/index",    // GET
        "/Gio-Hang/create",   // GET
        "/Gio-Hang/edit",     // GET
        "/Gio-Hang/delete",   // GET
        "/Gio-Hang/store",    // POST
        "/Gio-Hang/update",   // POST
})

public class GioHangServlet extends HttpServlet {
    private GioHangRepositry ghRepo;

    public GioHangServlet() {
        this.ghRepo = new GioHangRepositry();
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
        GioHang gh = this.ghRepo.findByMa(ma);
        request.setAttribute("gh", gh);
        request.getRequestDispatcher("/views/Gio_Hang/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GioHang gh = this.ghRepo.findByMa(ma);
        this.ghRepo.delete(gh);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachGH", this.ghRepo.findAll());
        request.setAttribute("views", "/views/Gio_Hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Gio_Hang/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            GioHang gh = new GioHang();
            BeanUtils.populate(gh, request.getParameterMap());
            this.ghRepo.insert(gh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            GioHang domainModelD = this.ghRepo.findByMa(ma);
            BeanUtils.populate(domainModelD, request.getParameterMap());
            this.ghRepo.update(domainModelD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Gio-Hang/index");
    }
}