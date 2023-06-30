package Domain_model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="ChucVu")
public class ChucVu {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    @OneToMany(
            mappedBy = "cv",
            fetch = FetchType.LAZY
    )
    private List<NhanVien> listNV;

    public ChucVu() {
    }

    public ChucVu(UUID id, String ma, String ten, List<NhanVien> listNV) {
        Id = id;
        Ma = ma;
        Ten = ten;
        this.listNV = listNV;
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

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public List<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(List<NhanVien> listNV) {
        this.listNV = listNV;
    }
}
