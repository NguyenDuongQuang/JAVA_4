package DomainModel;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@IdClass(HoaDonChiTietId.class)
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
    @Id
    @Column(name = "IdHoaDon")
    private UUID idHoaDon;

    @Id
    @Column(name = "IdChiTietSP")
    private UUID idChiTietSp;

    @ManyToOne
    @MapsId("idHoaDon")
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("idChiTietSp")
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(UUID idHoaDon, UUID idChiTietSp, HoaDon hoaDon, ChiTietSp chiTietSp, int soLuong, double donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
        this.hoaDon = hoaDon;
        this.chiTietSp = chiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public UUID getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(UUID idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
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
}
