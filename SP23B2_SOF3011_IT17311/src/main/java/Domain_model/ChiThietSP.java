package Domain_model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
public class ChiThietSP {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="NamBH")
    private String NamBH;

    @Column(name="MoTa")
    private String MoTa;

    @Column(name="Slt")
    private String Slt;

    @Column(name="GiaNhap")
    private String GiaNhap;

    @Column(name="GiaBan")
    private String GiaBan;

    public ChiThietSP() {
    }

    public ChiThietSP(UUID id, String ma, String namBH, String moTa, String slt, String giaNhap, String giaBan) {
        Id = id;
        Ma = ma;
        NamBH = namBH;
        MoTa = moTa;
        Slt = slt;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
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

    public String getNamBH() {
        return NamBH;
    }

    public void setNamBH(String namBH) {
        NamBH = namBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getSlt() {
        return Slt;
    }

    public void setSlt(String slt) {
        Slt = slt;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        GiaNhap = giaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String giaBan) {
        GiaBan = giaBan;
    }
}
