package view_model;

public class QLHoaDon {
    private String ma;
    private String ngay_tao;
    private String ngay_TT;
    private String ngay_ship;
    private String ngay_nhan;
    private String tinh_trang;
    private String tenNN;
    private String dia_chi;
    private String sdt;

    public QLHoaDon() {
    }

    public QLHoaDon(String ma, String ngay_tao, String ngay_TT, String ngay_ship, String ngay_nhan, String tinh_trang, String tenNN, String dia_chi, String sdt) {
        this.ma = ma;
        this.ngay_tao = ngay_tao;
        this.ngay_TT = ngay_TT;
        this.ngay_ship = ngay_ship;
        this.ngay_nhan = ngay_nhan;
        this.tinh_trang = tinh_trang;
        this.tenNN = tenNN;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
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

    public String getNgay_ship() {
        return ngay_ship;
    }

    public void setNgay_ship(String ngay_ship) {
        this.ngay_ship = ngay_ship;
    }

    public String getNgay_nhan() {
        return ngay_nhan;
    }

    public void setNgay_nhan(String ngay_nhan) {
        this.ngay_nhan = ngay_nhan;
    }

    public String getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(String tinh_trang) {
        this.tinh_trang = tinh_trang;
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
}
