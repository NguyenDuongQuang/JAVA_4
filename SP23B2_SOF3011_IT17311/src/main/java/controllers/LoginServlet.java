package controllers;

import Domain_model.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repositories.NhanVienRepositry;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private NhanVienRepositry nvRepo = new NhanVienRepositry();
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/login.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
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
            session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/khach-Hang/index");
        }
    }
}
