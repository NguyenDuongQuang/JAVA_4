package controller.admin;

import DomainModel.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;



@WebServlet({
        "/mau_sac/index",
        "/mau_sac/create",
        "/mau_sac/store",
        "/mau_sac/edit",
        "/mau_sac/update",
        "/mau_sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msrepo;

    public MauSacServlet(){
        this.msrepo = new MauSacRepository();
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
        String ma= request.getParameter("Ma");
        MauSac dmms = this.msrepo.findByMa(ma);
        request.setAttribute("ms",dmms);
        request.setAttribute("view","/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msrepo.findAll() );
        request.setAttribute("view","/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/mau_sac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("Ma");
        MauSac dmms = this.msrepo.findByMa(ma);
        if(dmms == null){
            System.out.println("Không tìm thấy ");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.msrepo.delete(dmms);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/mau_sac/index");

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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/mau_sac/index");
        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException ,IOException {
        String ma = request.getParameter("Ma");
        MauSac dmms = this.msrepo.findByMa(ma);
        try {
            BeanUtils.populate(dmms,request.getParameterMap());
            this.msrepo.update(dmms);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/mau_sac/index");
    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        MauSac dmms = new MauSac();
        try {
            BeanUtils.populate(dmms,request.getParameterMap());
            this.msrepo.insert(dmms);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Thêm thành công");
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/mau_sac/index");
    }
}
