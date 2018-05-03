package org.elsys.dao.Impl;

import org.elsys.dao.UserDao;
import org.elsys.entity.User;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentSession.close();
    }
    public void closeCurrentSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    private Session getCurrentSession(){
        return currentSession;
    }
    public void setCurrentSession(Session currentSession){
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction(){
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction){
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void insert(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void delete(long id) {
        getCurrentSession().delete(findById(id));
    }

    @Override
    public User findById(long id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByUsername(String name) {
        Query query= getCurrentSession().
                createQuery("from User where name=:name");
        query.setParameter("name", name);

        return (User) query.uniqueResult();
    }

    @Override
    public User findByGoogleId(String googleId) {
        Query query= getCurrentSession().
                createQuery("from User where googleId=:tokenId");
        query.setParameter("tokenId", googleId);
        return (User) query.uniqueResult();
    }
}
