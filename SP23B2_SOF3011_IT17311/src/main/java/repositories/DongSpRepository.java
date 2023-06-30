package repositories;

import DomainModel.DongSp;
import Utils.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class DongSpRepository {
    private Session hSession;

    public DongSpRepository()
    {
        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(DongSp dsp){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(dsp);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(DongSp dsp){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(dsp);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(DongSp dsp)
    {

        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(dsp);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<DongSp> findAll(){
        String hql = "SELECT dsp FROM DongSp dsp ";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql,DongSp.class);
        return query.getResultList();
    }

    public DongSp findByMa(String ma){
        String hql = "SELECT dsp FROM DongSp dsp WHERE dsp.ma = ?1";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql,DongSp.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}

