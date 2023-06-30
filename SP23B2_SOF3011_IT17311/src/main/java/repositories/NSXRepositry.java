package repositories;

import Domain_model.NSX;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLNSX;

import java.util.ArrayList;
import java.util.List;

public class NSXRepositry {
    private Session hSession;

    public NSXRepositry() {
        this.hSession= HibernateUtils.getFACTORY().openSession();
    }
    public void insert(NSX n){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(NSX n){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(NSX n){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NSX findById(String id){
        return this.hSession.find(NSX.class, id);
    }
    public List<NSX> findAll(){
        String hql="SELECT obj FROM NSX obj";
        TypedQuery<NSX> query = this.hSession.createQuery(hql,NSX.class);
        return query.getResultList();
    }
    public NSX findByMa(String ma){
        String hql="SELECT obj FROM NSX obj WHERE obj.Ma = ?1";
        TypedQuery<NSX>query = hSession.createQuery(hql,NSX.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
