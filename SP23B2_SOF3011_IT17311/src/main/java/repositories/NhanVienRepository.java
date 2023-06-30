
package repositories;

import DomainModel.NhanVien;
import Utils.HibernateUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository() {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(NhanVien qlms) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(qlms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public Boolean update(NhanVien qlms) {
        Transaction tran = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.update(qlms);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public void delete(NhanVien qlms) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(qlms);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<NhanVien> findAll() {
        List<NhanVien> listsNhanVien = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM NhanVien";
            Query query = session.createQuery(hql);
            listsNhanVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsNhanVien;
    }

    public NhanVien findByMa(String ma) {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }

    public NhanVien login(String ma, String matKhau) {
        String hql = "SELECT nv FROM NhanVien nv " +
                "WHERE nv.ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter(1, ma);
        q.setParameter(2, matKhau);

        try {
            NhanVien nv = q.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
