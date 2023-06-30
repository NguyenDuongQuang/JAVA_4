package controllers;

import Domain_model.ChucVu;
import Domain_model.DongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSPRepositry;
import view_model.QLDongSP;

import java.io.IOException;

@WebServlet({
        "/DongSP/index",    // GET
        "/DongSP/create",   // GET
        "/DongSP/edit",     // GET
        "/DongSP/delete",   // GET
        "/DongSP/store",    // POST
        "/DongSP/update",   // POST
})

public class DongSPServlet extends HttpServlet {
    private DongSPRepositry dRepo;
    public DongSPServlet(){
        this.dRepo = new DongSPRepositry();
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
        DongSP d = dRepo.findByMa(ma);
        request.setAttribute("d", d);
        request.getRequestDispatcher("/views/DongSP/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP domainModelD = this.dRepo.findByMa(ma);
        this.dRepo.delete(domainModelD);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/DongSP/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachD", this.dRepo.findAll());
        request.setAttribute("views","/views/DongSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/DongSP/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/DongSP/index");
        }

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            DongSP domainModelD = new DongSP();
            BeanUtils.populate(domainModelD, request.getParameterMap());
            this.dRepo.insert(domainModelD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/DongSP/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            DongSP domainModelD = this.dRepo.findByMa(ma);
            BeanUtils.populate(domainModelD, request.getParameterMap());
            this.dRepo.update(domainModelD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/DongSP/index");
    }
}
