package org.elsys.dao.Impl;

import org.elsys.dao.UserDao;
import org.elsys.entity.User;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public void insert(UserDao user) {

    }

    @Override
    public void update(UserDao user) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User findByUsername(String name) {
        return null;
    }
}
