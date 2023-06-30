package controllers;

import Domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NhanVienRepositry;
import view_model.QLNhanVien;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/Nhan-Vien/index",
        "/Nhan-Vien/create",
        "/Nhan-Vien/edit",
        "/Nhan-Vien/delete",
        "/Nhan-Vien/store",
        "/Nhan-Vien/update",
})

public class NhanVienServlet extends HttpServlet {
    private NhanVienRepositry nvRepo;

    public NhanVienServlet(){
        this.nvRepo = new NhanVienRepositry();
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
        NhanVien nv = this.nvRepo.findByMa(ma);
        request.setAttribute("nv", nv);
        request.getRequestDispatcher("/views/Nhan_Vien/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nvRepo.findByMa(ma);
        this.nvRepo.delete(nv);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Nhan-Vien/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNV", this.nvRepo.findAll());
        request.setAttribute("views","/views/Nhan_Vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException{
        request.getRequestDispatcher("/views/Nhan_Vien/create.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Nhan-Vien/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            NhanVien nv = new NhanVien();
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.insert(nv);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Nhan-Vien/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            NhanVien nv = this.nvRepo.findByMa(ma);
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.update(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Nhan-Vien/index");
    }
}
