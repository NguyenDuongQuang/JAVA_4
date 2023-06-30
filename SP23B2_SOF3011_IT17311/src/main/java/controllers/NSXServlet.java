package controllers;

import Domain_model.DongSP;
import Domain_model.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepositry;
import view_model.QLNSX;

import java.io.IOException;

@WebServlet({
        "/NSX/index",    // GET
        "/NSX/create",   // GET
        "/NSX/edit",     // GET
        "/NSX/delete",   // GET
        "/NSX/store",    // POST
        "/NSX/update",   // POST
})

public class NSXServlet extends HttpServlet {
    private NSXRepositry nsxRepo;
    public NSXServlet(){
        this.nsxRepo = new NSXRepositry();
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
        NSX n = this.nsxRepo.findByMa(ma);
        request.setAttribute("n", n);
        request.getRequestDispatcher("/views/NSX/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX n = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(n);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/NSX/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNSX", this.nsxRepo.findAll());
        request.setAttribute("views","/views/NSX/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/NSX/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/NSX/index");
        }

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            NSX domainModelD = new NSX();
            BeanUtils.populate(domainModelD, request.getParameterMap());
            this.nsxRepo.insert(domainModelD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/NSX/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            NSX n = this.nsxRepo.findByMa(ma);
            BeanUtils.populate(n, request.getParameterMap());
            this.nsxRepo.update(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/NSX/index");
    }
}
