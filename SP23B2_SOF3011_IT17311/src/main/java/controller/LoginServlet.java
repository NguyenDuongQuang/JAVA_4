package controller;

import jakarta.servlet.http.HttpServlet;
import DomainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.NhanVienRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public LoginServlet() {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp")
//        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVien nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = request.getSession();
        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/khach_hang/index");
        }
    }

}
