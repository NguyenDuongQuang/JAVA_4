package repositories;

import DomainModel.Nsx;
import Utils.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class NSXRepository {
    private Session hSession;

    public NSXRepository(){

        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(Nsx dmnsx){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(dmnsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(Nsx dmnsx){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(dmnsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(Nsx dmnsx)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(dmnsx);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<Nsx> findAll(){
        String hql = "SELECT nsx FROM Nsx nsx";
        TypedQuery<Nsx> query = this.hSession.createQuery(hql,Nsx.class);
        return query.getResultList();
    }

    public Nsx findByMa(String ma){
        String hql = "SELECT nsx FROM Nsx nsx WHERE nsx.ma = ?1";
        TypedQuery<Nsx> query = this.hSession.createQuery(hql,Nsx.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
