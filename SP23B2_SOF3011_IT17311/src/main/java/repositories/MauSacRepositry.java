package repositories;

import Domain_model.MauSac;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepositry {
    private Session hSession;

    public MauSacRepositry() {
        this.hSession= HibernateUtils.getFACTORY().openSession();
    }
    public void insert(MauSac ms){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(MauSac ms){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(MauSac ms){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public MauSac findById(String id){
        return this.hSession.find(MauSac.class, id);
    }
    public List<MauSac> findAll(){
        String hql="SELECT obj FROM MauSac obj";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql,MauSac.class);
        return query.getResultList();
    }
    public MauSac findByMa(String ma){
        String hql="SELECT obj FROM MauSac obj WHERE obj.Ma = ?1";
        TypedQuery<MauSac>query = hSession.createQuery(hql,MauSac.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
