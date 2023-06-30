package controller.admin;

import DomainModel.CuaHang;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/cua_hang/index",
        "/cua_hang/create",
        "/cua_hang/store",
        "/cua_hang/edit",
        "/cua_hang/update",
        "/cua_hang/delete",
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository msrepo;

    public CuaHangServlet(){
        this.msrepo = new CuaHangRepository();
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
        CuaHang dmch = this.msrepo.findByMa(ma);
        request.setAttribute("ch",dmch);
        request.setAttribute("view","/views/cua_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msrepo.findAll() );
        request.setAttribute("view","/views/cua_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/cua_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("ma");
        CuaHang dmch = this.msrepo.findByMa(ma);
        if(dmch == null){
            System.out.println("Không tìm thấy ");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.msrepo.delete(dmch);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/cua_hang/index");

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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/cua_hang/index");
        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException ,IOException {
        String ma = request.getParameter("Ma");
        CuaHang dmch = this.msrepo.findByMa(ma);
        try {
            BeanUtils.populate(dmch,request.getParameterMap());
            this.msrepo.update(dmch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/cua_hang/index");
    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        CuaHang dmch = new CuaHang();
        try {
            BeanUtils.populate(dmch,request.getParameterMap());
            this.msrepo.insert(dmch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/cua_hang/index");
    }
}


