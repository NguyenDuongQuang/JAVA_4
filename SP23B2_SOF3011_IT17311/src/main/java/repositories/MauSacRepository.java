package repositories;

import DomainModel.MauSac;
import Utils.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository(){

        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(MauSac ms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ms);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }

    }

    public void update(MauSac ms){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(ms);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(MauSac ms)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ms);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<MauSac> findAll(){
        String hql = "SELECT ms FROM MauSac ms ";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql,MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(String ma){
        String hql = "SELECT ms FROM MauSac ms WHERE ms.ma = ?1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql,MauSac.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
