package controller.admin;

import DomainModel.DongSp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import repositories.DongSpRepository;
import repositories.NSXRepository;


import java.io.IOException;
import java.util.ArrayList;
@WebServlet({
        "/dongsp/index",
        "/dongsp/create",
        "/dongsp/store",
        "/dongsp/edit",
        "/dongsp/update",
        "/dongsp/delete",
})
public class DongSPServlet extends HttpServlet {
    private DongSpRepository dongsp;
    public DongSPServlet(){
        this.dongsp = new DongSpRepository();
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
        DongSp dmdsp = this.dongsp.findByMa(ma);
        request.setAttribute("dsp",dmdsp);
        request.setAttribute("view","/views/dongsp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.dongsp.findAll());
        request.setAttribute("view","/views/dongsp/index.jsp");
       request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/dongsp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("ma");
        DongSp qlms = this.dongsp.findByMa(ma);
        if(qlms == null){
            System.out.println("Không tìm thấy ");
        }else{
            this.dongsp.delete(qlms);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/dongsp/index");

        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/dongsp/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException , IOException{
        String ma = request.getParameter("ma");
        DongSp dmdsp = this.dongsp.findByMa(ma);
        try {
            BeanUtils.populate(dmdsp,request.getParameterMap());
            this.dongsp.update(dmdsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/dongsp/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        DongSp dmdsp = new DongSp();
        try {
            BeanUtils.populate(dmdsp,request.getParameterMap());
            this.dongsp.update(dmdsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/dongsp/index");
    }
}
