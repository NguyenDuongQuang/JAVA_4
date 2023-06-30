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
@Table(name = "NSX")
public class Nsx  implements Serializable {
    @Id
    @Column(name = "Id", columnDefinition="uniqueidentifier")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "nsx",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSp> chiTietSps;

    }
