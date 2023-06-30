package repositories;

import DomainModel.CuaHang;
import Utils.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {
    private Session hSession;

    public CuaHangRepository(){

        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(CuaHang ch){

        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ch);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(CuaHang ch){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(ch);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(CuaHang ch)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ch);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }


    public List<CuaHang> findAll(){
        String hql = "SELECT ch FROM CuaHang ch";
        TypedQuery<CuaHang>query =this.hSession.createQuery(hql,CuaHang.class);
        return query.getResultList();
    }

    public CuaHang findByMa(String ma){
        String hql = "SELECT ch FROM CuaHang ch WHERE ch.ma = ?1";
        TypedQuery<CuaHang>query =this.hSession.createQuery(hql,CuaHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }

    public static void main(String[] args) {

        System.out.println(   new CuaHangRepository().findAll().size());
    }
}
