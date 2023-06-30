package controller.admin;

import DomainModel.ChucVu;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet({
        "/chuc_vu/index",
        "/chuc_vu/create",
        "/chuc_vu/store",
        "/chuc_vu/edit",
        "/chuc_vu/update",
        "/chuc_vu/delete",
})

public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository msrepo;

    public ChucVuServlet(){
        this.msrepo= new ChucVuRepository();
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
        ChucVu dmcv = this.msrepo.findByMa(ma);
        request.setAttribute("cv",dmcv);
        request.setAttribute("view","/views/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach",this.msrepo.findAll() );
        request.setAttribute("view","/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/chuc_vu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException,IOException{
        String ma = request.getParameter("Ma");
        ChucVu dmcv = this.msrepo.findByMa(ma);
        if(dmcv == null){
            System.out.println("Không tìm thấy ");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.msrepo.delete(dmcv);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chuc_vu/index");

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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chuc_vu/index");
        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException ,IOException {
        String ma = request.getParameter("Ma");
        ChucVu dmcv =  this.msrepo.findByMa(ma);
        try {
            BeanUtils.populate(dmcv,request.getParameterMap());
            this.msrepo.update(dmcv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chuc_vu/index");
    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        ChucVu dmcv =  new ChucVu();
        try {
            BeanUtils.populate(dmcv,request.getParameterMap());
            this.msrepo.insert(dmcv);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Thêm thành công");
        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chuc_vu/index");
    }


}
