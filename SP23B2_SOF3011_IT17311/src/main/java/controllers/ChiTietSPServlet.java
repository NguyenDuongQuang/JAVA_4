package controllers;

import Domain_model.ChiThietSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChiTieSPRepositry;
import view_model.QLChiTietSP;

import java.io.IOException;

@WebServlet({
        "/Chi-Tiet-SP/index",    // GET
        "/Chi-Tiet-SP/create",   // GET
        "/Chi-Tiet-SP/edit",     // GET
        "/Chi-Tiet-SP/delete",   // GET
        "/Chi-Tiet-SP/store",    // POST
        "/Chi-Tiet-SP/update",   // POST
})

public class ChiTietSPServlet extends HttpServlet {
    private ChiTieSPRepositry ctspRepo;

    public ChiTietSPServlet() {
        this.ctspRepo = new ChiTieSPRepositry();
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
        ChiThietSP ct = this.ctspRepo.findByMa(ma);
        request.setAttribute("ct", ct);
        request.getRequestDispatcher("/views/Chi_Tiet_SP/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiThietSP ct = this.ctspRepo.findByMa(ma);
        this.ctspRepo.delete(ct);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chi-Tiet-SP/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCTSP", this.ctspRepo.findAll());
        request.setAttribute("views","/views/Chi_Tiet_SP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Chi_Tiet_SP/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chi-Tiet-SP/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            ChiThietSP ct = new ChiThietSP();
            BeanUtils.populate(ct, request.getParameterMap());
            this.ctspRepo.insert(ct);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chi-Tiet-SP/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChiThietSP domainModelCT = this.ctspRepo.findByMa(ma);
            BeanUtils.populate(domainModelCT, request.getParameterMap());
            this.ctspRepo.update(domainModelCT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Chi-Tiet-SP/index");
    }
}
