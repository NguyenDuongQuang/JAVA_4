package repositories;

import Domain_model.CuaHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLCuaHang;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepositry {
    private Session hSession;
    public CuaHangRepositry(){
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }
    public void insert(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(CuaHang ch) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public CuaHang findById(String id) {
        return this.hSession.find(CuaHang.class, id);
    }
    public List<CuaHang> findAll() {
        String hql = "SELECT obj FROM CuaHang obj";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql, CuaHang.class);
        return query.getResultList();
    }
    public CuaHang findByMa(String ma) {
        String hql = "SELECT obj FROM CuaHang obj WHERE obj.Ma = ?1";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql, CuaHang.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
