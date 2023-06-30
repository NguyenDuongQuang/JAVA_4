package repositories;

import DomainModel.ChiTietSp;
import Utils.HibernateUtils;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class ChitietSPRepository {
    private Session hSession;

    public ChitietSPRepository() {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(ChiTietSp dmctsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(dmctsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(ChiTietSp dmctsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(dmctsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(ChiTietSp dmctsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(dmctsp);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            this.hSession.getTransaction().rollback();
        }
    }

    public List<ChiTietSp> findAll() {
        List<ChiTietSp> listsChiTietSanPham = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM ChiTietSp";
            Query query = session.createQuery(hql);
            listsChiTietSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsChiTietSanPham;
    }

    public ChiTietSp findByMa(String ma) {
        String hql = "SELECT ctsp FROM ChiTietSp ctsp WHERE ctsp.id = ?1";
        TypedQuery<ChiTietSp> query = this.hSession.createQuery(hql, ChiTietSp.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }

    public static void main(String[] args) {
        System.out.println("" + new ChitietSPRepository().findAll());
    }
}
