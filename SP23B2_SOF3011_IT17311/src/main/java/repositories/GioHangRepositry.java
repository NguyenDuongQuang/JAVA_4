package repositories;

import Domain_model.DongSP;
import Domain_model.GioHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLGioHang;

import java.util.ArrayList;
import java.util.List;

public class GioHangRepositry {
    private Session hSession;

    public GioHangRepositry() {
        this.hSession= HibernateUtils.getFACTORY().openSession();
    }
    public void insert(GioHang gh){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(GioHang gh){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(GioHang gh){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public GioHang findById(String id){
        return this.hSession.find(GioHang.class, id);
    }
    public List<GioHang> findAll(){
        String hql="SELECT obj FROM GioHang obj";
        TypedQuery<GioHang> query = this.hSession.createQuery(hql,GioHang.class);
        return query.getResultList();
    }
    public GioHang findByMa(String ma){
        String hql="SELECT obj FROM GioHang obj WHERE obj.Ma = ?1";
        TypedQuery<GioHang>query = hSession.createQuery(hql,GioHang.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
