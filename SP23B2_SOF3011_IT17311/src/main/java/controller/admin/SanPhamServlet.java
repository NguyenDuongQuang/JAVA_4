package controller.admin;

import DomainModel.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepository;
import repositories.SanPhamRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet({
        "/san_pham/index",
        "/san_pham/create",
        "/san_pham/store",
        "/san_pham/edit",
        "/san_pham/update",
        "/san_pham/delete",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;
    public SanPhamServlet(){
        this.spRepo = new SanPhamRepository();
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
        SanPham qlms = this.spRepo.findByMa(ma);
        request.setAttribute("sp",qlms);
        request.setAttribute("view","/views/san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.spRepo.findAll());
        request.setAttribute("view","/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("ma");
        SanPham qlms = this.spRepo.findByMa(ma);
        if(qlms == null){
            System.out.println("Không tìm thấy ");
        }else{
            this.spRepo.delete(qlms);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/san_pham/index");

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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/san_pham/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException, IOException{
        String ma = request.getParameter("ma");
        SanPham qlsp = this.spRepo.findByMa(ma);
        try {
            BeanUtils.populate(qlsp,request.getParameterMap());
            this.spRepo.update(qlsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/san_pham/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        SanPham qlsp = new SanPham();
        try {
            BeanUtils.populate(qlsp,request.getParameterMap());
            this.spRepo.insert(qlsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/san_pham/index");
    }
}
