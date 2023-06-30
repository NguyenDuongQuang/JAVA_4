package repositories;

import DomainModel.ChucVu;
import Utils.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hSession;

    public ChucVuRepository(){

        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(ChucVu cv){
        try{
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(ChucVu cv){
        try{
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(ChucVu cv)
    {try{
        this.hSession.getTransaction().begin();
        this.hSession.delete(cv);
        this.hSession.getTransaction().commit();
    }catch (Exception e){
        e.printStackTrace();
        this.hSession.getTransaction().rollback();
    }
    }

    public ChucVu findByID(UUID Id){
        return this.hSession.find(ChucVu.class,Id);
    }

    public List<ChucVu> findAll(){
        String hql = "SELECT cv FROM ChucVu cv";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(String ma){
        String hql = "SELECT cv FROM ChucVu cv WHERE cv.ma = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }

}
