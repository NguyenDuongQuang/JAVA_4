package Domain_model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="GioHang")
public class GioHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="NgayTao")
    private String NgayTao;
    @Column(name="NgayTT")
    private String NgayTT;
    @Column(name="TenNN")
    private String TenNN;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="TinhTrang")
    private String TinhTrang;

    public GioHang() {
    }

    public GioHang(UUID id, String ma, String ngayTao, String ngayTT, String tenNN, String diaChi, String sdt, String tinhTrang) {
        Id = id;
        Ma = ma;
        NgayTao = ngayTao;
        NgayTT = ngayTT;
        TenNN = tenNN;
        DiaChi = diaChi;
        Sdt = sdt;
        TinhTrang = tinhTrang;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        NgayTao = ngayTao;
    }

    public String getNgayTT() {
        return NgayTT;
    }

    public void setNgayTT(String ngayTT) {
        NgayTT = ngayTT;
    }

    public String getTenNN() {
        return TenNN;
    }

    public void setTenNN(String tenNN) {
        TenNN = tenNN;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }
}
