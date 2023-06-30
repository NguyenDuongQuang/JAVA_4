package DomainModel;

import java.io.Serializable;
import java.util.UUID;

public class GioHangChiTietId implements Serializable {

    private UUID idGioHang;
    private UUID idChiTietSp;

    public GioHangChiTietId() {
    }

    public GioHangChiTietId(UUID idGioHang, UUID idChiTietSp) {
        this.idGioHang = idGioHang;
        this.idChiTietSp = idChiTietSp;
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
}
