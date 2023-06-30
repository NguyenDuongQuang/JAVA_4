package controllers;

import Domain_model.ChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepositry;
import view_model.QLChucVu;

import java.io.IOException;

@WebServlet({
        "/Chuc-Vu/index",    // GET
        "/Chuc-Vu/create",   // GET
        "/Chuc-Vu/edit",     // GET
        "/Chuc-Vu/delete",   // GET
        "/Chuc-Vu/store",    // POST
        "/Chuc-Vu/update",   // POST
})

public class ChucVuServlet extends HttpServlet {
    private ChucVuRepositry cvRepo;
    public ChucVuServlet(){
        this.cvRepo = new ChucVuRepositry();
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
        ChucVu domainModelCV = this.cvRepo.findByMa(ma);
        request.setAttribute("cv", domainModelCV);
        request.getRequestDispatcher("/views/Chuc_Vu/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu domainModelCV = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(domainModelCV);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chuc-Vu/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCV", this.cvRepo.findAll());
        request.setAttribute("views","/views/Chuc_Vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Chuc_Vu/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chuc-Vu/index");
        }

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            ChucVu domainModelKH = new ChucVu();
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.cvRepo.insert(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chuc-Vu/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChucVu domainModelKH = this.cvRepo.findByMa(ma);
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.cvRepo.update(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chuc-Vu/index");
    }
}
