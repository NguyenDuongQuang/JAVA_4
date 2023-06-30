package repositories;

import view_model.QLHoaDon;

import java.util.ArrayList;

public class HoaDonRepositry {
    private ArrayList<QLHoaDon> list;
    public HoaDonRepositry()
    {
        this.list = new ArrayList<>();
    }
    public void insert(QLHoaDon hd) { this.list.add(hd); }
    public void update(QLHoaDon hd) {
        for (int i = 0; i < this.list.size(); i++) {
            QLHoaDon item = this.list.get(i);
            if (item.getMa().equals(hd.getMa())) {
                this.list.set(i, hd);
            }
        }
    }
    public void delete(QLHoaDon hd) {
        for (int i = 0; i < this.list.size(); i++) {
            QLHoaDon item = this.list.get(i);
            if (item.getMa().equals(hd.getMa())) {
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLHoaDon> findAll() {
        return list;
    }
    public QLHoaDon findByMa(String ma) {
        for (int i = 0; i < this.list.size(); i++) {
            QLHoaDon item = this.list.get(i);
            if (item.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
