package repositories;

import Domain_model.ChiThietSP;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLChiTietSP;

import java.util.ArrayList;
import java.util.List;

public class ChiTieSPRepositry {
    private Session hSession;
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(ChiThietSP ct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(ChiThietSP ct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(ChiThietSP ct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public ChiThietSP findById(String id) {
        return this.hSession.find(ChiThietSP.class, id);
    }
    public List<ChiThietSP> findAll() {
        String hql = "SELECT obj FROM ChiThietSP obj";
        TypedQuery<ChiThietSP> query = this.hSession.createQuery(hql, ChiThietSP.class);
        return query.getResultList();
    }
    public ChiThietSP findByMa(String ma) {
        String hql = "SELECT obj FROM ChiThietSP obj WHERE obj.Ma = ?1";
        TypedQuery<ChiThietSP> query = this.hSession.createQuery(hql, ChiThietSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
