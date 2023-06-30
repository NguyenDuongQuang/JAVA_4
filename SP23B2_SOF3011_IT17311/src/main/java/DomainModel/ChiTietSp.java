
package DomainModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSp implements Serializable {
    @Id
    @Column(name = "Id", columnDefinition="uniqueidentifier")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private Nsx nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSp dongSp;

    @Column(name = "NamBH")
    private int namBh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private double giaNhap;

    @Column(name = "GiaBan")
    private double giaBan;

    @OneToMany(mappedBy = "chiTietSp",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets;

    @OneToMany(mappedBy = "chiTietSp",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;

}
