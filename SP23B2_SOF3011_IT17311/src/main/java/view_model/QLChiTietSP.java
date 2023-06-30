package view_model;

public class QLChiTietSP {
    private String ma;
    private String nam_bh;
    private String mo_ta;
    private String slt;
    private String gia_nhap;
    private String gia_ban;

    public QLChiTietSP() {
    }

    public QLChiTietSP(String ma, String nam_bh, String mo_ta, String slt, String gia_nhap, String gia_ban) {
        this.ma = ma;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.slt = slt;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNam_bh() {
        return nam_bh;
    }

    public void setNam_bh(String nam_bh) {
        this.nam_bh = nam_bh;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getSlt() {
        return slt;
    }

    public void setSlt(String slt) {
        this.slt = slt;
    }

    public String getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(String gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public String getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(String gia_ban) {
        this.gia_ban = gia_ban;
    }
}
