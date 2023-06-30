package repositories;

import Domain_model.DongSP;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLDongSP;

import java.util.ArrayList;
import java.util.List;

public class DongSPRepositry {
     private Session hSession;

    public DongSPRepositry() {
        this.hSession= HibernateUtils.getFACTORY().openSession();
    }
    public void insert(DongSP d){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(DongSP d){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(DongSP d){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public DongSP findById(String id){
        return this.hSession.find(DongSP.class, id);
    }
    public List<DongSP> findAll(){
        String hql="SELECT obj FROM DongSP obj";
        TypedQuery<DongSP>query = this.hSession.createQuery(hql,DongSP.class);
         return query.getResultList();
    }
    public DongSP findByMa(String ma){
        String hql="SELECT obj FROM DongSP obj WHERE obj.Ma = ?1";
        TypedQuery<DongSP>query = hSession.createQuery(hql,DongSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
