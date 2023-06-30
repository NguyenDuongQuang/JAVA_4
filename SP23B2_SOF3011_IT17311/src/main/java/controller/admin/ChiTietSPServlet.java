package controller.admin;

import DomainModel.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import repositories.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/chi_tietsp/index",
        "/chi_tietsp/create",
        "/chi_tietsp/store",
        "/chi_tietsp/edit",
        "/chi_tietsp/update",
        "/chi_tietsp/delete",
})

public class ChiTietSPServlet extends HttpServlet {
    private ChitietSPRepository ctspRepo;
    private List<ChiTietSp> listsChiTietSps;

    public ChiTietSPServlet() {
        this.ctspRepo = new ChitietSPRepository();
        this.listsChiTietSps = new ArrayList<>();
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
        } else if (uri.contains("index")) {
            this.index(request, response);
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        listsChiTietSps = ctspRepo.findAll();
        listsChiTietSps.forEach(c -> {
//            System.out.println( c.getMoTa());
        });
        request.setAttribute("danhSach", listsChiTietSps);
        request.setAttribute("view", "/views/chi_tietsp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        List<SanPham> lsp = new SanPhamRepository().findAll();
        request.setAttribute("sp", lsp);

        List<DongSp> ldsp = new DongSpRepository().findAll();
        request.setAttribute("dsp", ldsp);

        List<MauSac> lms = new MauSacRepository().findAll();
        request.setAttribute("ms", lms);

        List<Nsx> lnsx = new NSXRepository().findAll();
        request.setAttribute("nsx", lnsx);

        String ma = request.getParameter("id");
        ChiTietSp ctsp = this.ctspRepo.findByMa(ma);
        request.setAttribute("ctsp", ctsp);
        request.setAttribute("view", "/views/chi_tietsp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSp kh = this.ctspRepo.findByMa(id);
        if (kh == null) {
            System.out.println("Không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.ctspRepo.delete(kh);
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/index");
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        List<SanPham> lsp = new SanPhamRepository().findAll();
        request.setAttribute("sp", lsp);
        List<DongSp> ldsp = new DongSpRepository().findAll();
        request.setAttribute("dsp", ldsp);
        List<MauSac> lms = new MauSacRepository().findAll();
        request.setAttribute("ms", lms);
        List<Nsx> lnsx = new NSXRepository().findAll();
        request.setAttribute("nsx", lnsx);
        request.setAttribute("view", "/views/chi_tietsp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
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
            response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String id = request.getParameter("id");

        String idSP = request.getParameter("idSP");
        String idNSX = request.getParameter("idNSX");
        String idDongSP = request.getParameter("idDSP");
        String idMauSac = request.getParameter("idMS");
        int namBH = Integer.parseInt(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
        double giaBan = Double.parseDouble(request.getParameter("giaBan"));

        System.out.println(soLuongTon);
        System.out.println(moTa);
        new ChitietSPRepository().update(ChiTietSp.builder()
                .id(id)
                .sanPham(SanPham.builder().id(idSP).build())
                .nsx(Nsx.builder().id(idNSX).build())
                .mauSac(MauSac.builder().id(idMauSac).build())
                .dongSp(DongSp.builder().id(idDongSP).build())
                .namBh(namBH)
                .moTa(moTa)
                .soLuongTon(soLuongTon)
                .giaNhap(giaNhap)
                .giaBan(giaBan)
                .build());

        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String idSP = request.getParameter("idSP");
        String idNSX = request.getParameter("idNSX");
        String idDongSP = request.getParameter("idDSP");
        String idMauSac = request.getParameter("idMS");

        int namBH = Integer.parseInt(request.getParameter("namBH"));
        String moTa = request.getParameter("moTa");
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
        double giaBan = Double.parseDouble(request.getParameter("giaBan"));

        new ChitietSPRepository().insert(ChiTietSp.builder()
                .sanPham(SanPham.builder().id(idSP).build())
                .nsx(Nsx.builder().id(idNSX).build())
                .mauSac(MauSac.builder().id(idMauSac).build())
                .dongSp(DongSp.builder().id(idDongSP).build())
                .namBh(namBH)
                .moTa(moTa)
                .soLuongTon(soLuongTon)
                .giaNhap(giaNhap)
                .giaBan(giaBan)
                .build());


        response.sendRedirect("/SP23B2_SOF3011_IT17311_war_exploded/chi_tietsp/index");
    }


}
