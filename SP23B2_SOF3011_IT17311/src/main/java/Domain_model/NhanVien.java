package Domain_model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="NhanVien")
public class NhanVien {
    @jakarta.persistence.Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ho")
    private String Ho;

    @Column(name="tenDem")
    private String TenDem;

    @Column(name="ten")
    private String Ten;

    @Column(name="GioiTinh")
    private String GioiTinh;

    @Column(name="NgaySinh")
    private Date NgaySinh;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="Sdt")
    private String Sdt;

    @Column(name="matKhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH",
    referencedColumnName = "id")
    private CuaHang ch;
    @ManyToOne
    @JoinColumn(name="IdCV", referencedColumnName = "Id")
    private ChucVu cv;

    @Column(name="IdGuiBC")
    private UUID idGuiBC;

    @Column(name="TrangThai")
    private Integer TrangThai;

    public NhanVien() {
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

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String tenDem) {
        TenDem = tenDem;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public CuaHang getCh() {
        return ch;
    }

    public void setCh(CuaHang ch) {
        this.ch = ch;
    }

    public ChucVu getCv() {
        return cv;
    }

    public void setCv(ChucVu cv) {
        this.cv = cv;
    }

    public UUID getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(UUID idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public Integer getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Integer trangThai) {
        TrangThai = trangThai;
    }
}
