package repositories;

import Domain_model.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import view_model.QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepositry {
    private Session hSession;

    public NhanVienRepositry() {
        this.hSession= HibernateUtils.getFACTORY().openSession();
    }
    public void insert(NhanVien nv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(NhanVien nv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(NhanVien nv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NhanVien findById(String id){
        return this.hSession.find(NhanVien.class, id);
    }
    public List<NhanVien> findAll(){
        String hql="SELECT obj FROM NhanVien obj";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql,NhanVien.class);
        return query.getResultList();
    }
    public NhanVien findByMa(String ma){
        String hql="SELECT obj FROM NhanVien obj WHERE obj.Ma = ?1";
        TypedQuery<NhanVien>query = hSession.createQuery(hql,NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.Ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);
        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
