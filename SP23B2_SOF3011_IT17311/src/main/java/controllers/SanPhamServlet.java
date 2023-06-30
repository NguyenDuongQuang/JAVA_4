package controllers;

import Domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepositry;
import view_model.QLSanPham;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/San-Pham/index",    // GET
        "/San-Pham/create",   // GET
        "/San-Pham/edit",     // GET
        "/San-Pham/delete",   // GET
        "/San-Pham/store",    // POST
        "/San-Pham/update",   // POST
})

public class SanPhamServlet extends HttpServlet {
    private SanPhamRepositry spRepo;
    public SanPhamServlet(){
        this.spRepo = new SanPhamRepositry();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request, response);
        }
        else if (uri.contains("edit")){
            this.edit(request, response);
        }
        else if (uri.contains("delete")) {
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
        SanPham sp = this.spRepo.findByMa(ma);
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/views/San_Pham/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.spRepo.findByMa(ma);
        this.spRepo.delete(sp);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/San-Pham/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachSP", this.spRepo.findAll());
        request.setAttribute("views","/views/San_Pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/San_Pham/create.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")){
            this.store(request, response);
        } else if (uri.contains("update")){
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/San-Pham/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            SanPham domainModelSP = new SanPham();
            BeanUtils.populate(domainModelSP, request.getParameterMap());
            this.spRepo.insert(domainModelSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/San-Pham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            SanPham domainModelSP = this.spRepo.findByMa(ma);
            BeanUtils.populate(domainModelSP, request.getParameterMap());
            this.spRepo.update(domainModelSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/San-Pham/index");
    }
}
