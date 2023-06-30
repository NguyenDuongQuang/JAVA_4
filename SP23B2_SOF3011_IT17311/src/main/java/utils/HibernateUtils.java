package utils;

import Domain_model.*;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

public class HibernateUtils {
        private static final SessionFactory FACTORY;

        static {
            Configuration conf = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
            properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=SP23B2_SOF3011_IT17311");
            properties.put(Environment.USER, "sa");
            properties.put(Environment.PASS, "123456");
            properties.put(Environment.SHOW_SQL, "true");

            conf.setProperties(properties);
            conf.addAnnotatedClass(KhachHang.class);
            conf.addAnnotatedClass(ChiThietSP.class);
            conf.addAnnotatedClass(ChucVu.class);
            conf.addAnnotatedClass(CuaHang.class);
            conf.addAnnotatedClass(DongSP.class);
            conf.addAnnotatedClass(GioHang.class);
            conf.addAnnotatedClass(HoaDon.class);
            conf.addAnnotatedClass(MauSac.class);
            conf.addAnnotatedClass(NhanVien.class);
            conf.addAnnotatedClass(NSX.class);
            conf.addAnnotatedClass(SanPham.class);
            ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();
            FACTORY = conf.buildSessionFactory(registry);

        }

        public static SessionFactory getFACTORY() {
            return FACTORY;
        }

        public static void main(String[] args) {
            Session hSession = getFACTORY().openSession();
            String hql = "SELECT cvObj FROM ChucVu cvObj WHERE cvObj.Ma = ?1";
            TypedQuery<ChucVu> q = hSession.createQuery(hql, ChucVu.class);
            q.setParameter(1, "1");
            ChucVu cv = q.getSingleResult();
            System.out.println(cv.getTen());

            List<NhanVien> listNv = cv.getListNV();
            NhanVien nv = listNv.get(0);
            System.out.println(nv.getHo() + " " + nv.getTenDem() + " " + nv.getTen());
        }
}
