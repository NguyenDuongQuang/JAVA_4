package view_model;

public class QLGioHang {
    private String ma;
    private String ngay_tao;
    private String ngay_TT;
    private String tenNN;
    private String dia_chi;
    private String sdt;
    private String tinh_trang;

    public QLGioHang() {
    }

    public QLGioHang(String ma, String ngay_tao, String ngay_TT, String tenNN, String dia_chi, String sdt, String tinh_trang) {
        this.ma = ma;
        this.ngay_tao = ngay_tao;
        this.ngay_TT = ngay_TT;
        this.tenNN = tenNN;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.tinh_trang = tinh_trang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(String ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public String getNgay_TT() {
        return ngay_TT;
    }

    public void setNgay_TT(String ngay_TT) {
        this.ngay_TT = ngay_TT;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(String tinh_trang) {
        this.tinh_trang = tinh_trang;
    }
}
