package Domain_model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="DongSP")
public class DongSP {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    public DongSP() {
    }

    public DongSP(UUID id, String ma, String ten) {
        Id = id;
        Ma = ma;
        Ten = ten;
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
}
