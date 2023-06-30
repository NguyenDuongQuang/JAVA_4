package repositories;

import DomainModel.SanPham;
import Utils.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private Session hSession;

    public SanPhamRepository(){

        this.hSession = HibernateUtils.getFACTORY().openSession();
    }

    public void insert(SanPham qlsp){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(qlsp);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(SanPham qlsp){
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(qlsp);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }
    public void delete(SanPham qlsp)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(qlsp);
            this.hSession.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<SanPham> findAll(){
        String hql = "SELECT sp FROM SanPham sp ";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql,SanPham.class);
        return query.getResultList();

    }

    public SanPham findByMa(String ma){
        String hql = "SELECT sp FROM SanPham sp WHERE sp.ma = ?1 ";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql,SanPham.class);
        query.setParameter(1,ma);
        return query.getSingleResult();

    }
}
