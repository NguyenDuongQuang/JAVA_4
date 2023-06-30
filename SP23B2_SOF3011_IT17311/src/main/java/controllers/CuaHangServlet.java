package controllers;

import Domain_model.ChucVu;
import Domain_model.CuaHang;
import Domain_model.DongSP;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepositry;
import view_model.QLCuaHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/Cua-Hang/index",    // GET
        "/Cua-Hang/create",   // GET
        "/Cua-Hang/edit",     // GET
        "/Cua-Hang/delete",   // GET
        "/Cua-Hang/store",    // POST
        "/Cua-Hang/update",   // POST
})

public class CuaHangServlet extends HttpServlet {
    private CuaHangRepositry chRepo;
    public CuaHangServlet(){ this.chRepo = new CuaHangRepositry(); }
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")){
            this.create(request, response);
        } else if (uri.contains("edit")){
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
        CuaHang ch = this.chRepo.findByMa(ma);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/views/Cua_Hang/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.chRepo.findByMa(ma);
        this.chRepo.delete(ch);
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Cua-Hang/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
         request.setAttribute("danhSachCH", this.chRepo.findAll());
        request.setAttribute("views","/views/Cua_Hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Cua_Hang/create.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request, response);
        } else if(uri.contains("update")){
            this.update(request, response);
        }else {
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Cua-Hang/index");
        }

    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            CuaHang domainModelCH = new CuaHang();
            BeanUtils.populate(domainModelCH, request.getParameterMap());
            this.chRepo.insert(domainModelCH);
        } catch (Exception e) {
            e.printStackTrace();

            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/Cua-Hang/index");
        }
    }

        protected void update(
                HttpServletRequest request,
                HttpServletResponse response
    ) throws ServletException, IOException {
            try {
                String ma = request.getParameter("ma");
                CuaHang domainModelD = this.chRepo.findByMa(ma);
                BeanUtils.populate(domainModelD, request.getParameterMap());
                this.chRepo.update(domainModelD);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/DongSP/index");
        }
}
