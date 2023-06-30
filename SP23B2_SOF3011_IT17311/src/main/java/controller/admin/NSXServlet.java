package controller.admin;

import DomainModel.Nsx;
import Utils.HibernateUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import repositories.NSXRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet({
        "/nsx/index",
        "/nsx/create",
        "/nsx/store",
        "/nsx/edit",
        "/nsx/update",
        "/nsx/delete",
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepo;

    public NSXServlet(){
        this.nsxRepo = new NSXRepository();
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
    )throws ServletException,IOException{
        String ma= request.getParameter("ma");
        Nsx qlms = this.nsxRepo.findByMa(ma);
        request.setAttribute("nsx",qlms);
        request.setAttribute("view","/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.nsxRepo.findAll());
        request.setAttribute("view","/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("ma");
        Nsx qlms = this.nsxRepo.findByMa(ma);
        if(qlms == null){
            System.out.println("Không tìm thấy ");
        }else{
            this.nsxRepo.delete(qlms);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nsx/index");

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
        }else{
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nsx/index");
        }
    }
    protected  void update(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("ma");
        Nsx qlnsx = this.nsxRepo.findByMa(ma);
        try {
            BeanUtils.populate(qlnsx,request.getParameterMap());
            this.nsxRepo.update(qlnsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nsx/index");

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        Nsx qlnsx = new Nsx();
        try {
            BeanUtils.populate(qlnsx,request.getParameterMap());
            this.nsxRepo.insert(qlnsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/nsx/index");
    }
}
