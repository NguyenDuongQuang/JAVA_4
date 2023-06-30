package DomainModel;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "GioHangChiTiet")
@IdClass(GioHangChiTietId.class)
public class GioHangChiTiet implements Serializable {
    @Id
    @Column(name = "IdGioHang")
    private UUID idGioHang;

    @Id
    @Column(name = "IdChiTietSP")
    private UUID idChiTietSp;

    @ManyToOne
    @MapsId("idGioHang")
    @JoinColumn(name = "IdGioHang", referencedColumnName = "Id")
    private GioHang gioHang;

    @ManyToOne
    @MapsId("idChiTietSp")
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private double donGia;

    @Column(name = "DonGiaKhiGiam")
    private double donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(UUID idGioHang, UUID idChiTietSp, GioHang gioHang, ChiTietSp chiTietSp, int soLuong, double donGia, double donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTietSp = idChiTietSp;
        this.gioHang = gioHang;
        this.chiTietSp = chiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public UUID getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(UUID idGioHang) {
        this.idGioHang = idGioHang;
    }

    public UUID getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(UUID idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public ChiTietSp getChiTietSp() {
        return chiTietSp;
    }

    public void setChiTietSp(ChiTietSp chiTietSp) {
        this.chiTietSp = chiTietSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
}
