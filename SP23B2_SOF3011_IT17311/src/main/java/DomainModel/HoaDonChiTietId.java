package DomainModel;

import java.io.Serializable;
import java.util.UUID;

public class HoaDonChiTietId implements Serializable {

    private UUID idHoaDon;

    private UUID idChiTietSp;

    public HoaDonChiTietId() {
    }

    public HoaDonChiTietId(UUID idHoaDon, UUID idChiTietSp) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
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
}
