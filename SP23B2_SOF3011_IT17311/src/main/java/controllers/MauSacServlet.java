package controllers;

import Domain_model.DongSP;
import Domain_model.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepositry;
import view_model.QLMauSac;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/Mau-Sac/index",    // GET
        "/Mau-Sac/create",   // GET
        "/Mau-Sac/edit",     // GET
        "/Mau-Sac/delete",   // GET
        "/Mau-Sac/store",    // POST
        "/Mau-Sac/update",   // POST
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepositry msRepo;
    public MauSacServlet(){
        this.msRepo = new MauSacRepositry();
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
        MauSac ms = msRepo.findByMa(ma);
        request.setAttribute("ms", ms);
        request.getRequestDispatcher("/views/Mau_Sac/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = msRepo.findByMa(ma);
        this.msRepo.delete(ms);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachMS", this.msRepo.findAll());
        request.setAttribute("views","/views/Mau_Sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Mau_Sac/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/index");
        }

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            MauSac domainModelD = new MauSac();
            BeanUtils.populate(domainModelD, request.getParameterMap());
            this.msRepo.insert(domainModelD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            MauSac ms = this.msRepo.findByMa(ma);
            BeanUtils.populate(ms, request.getParameterMap());
            this.msRepo.update(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Mau-Sac/index");
    }
}
