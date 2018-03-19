package org.elsys.dao.Impl;

import org.elsys.dao.SessionDao;
import org.elsys.entity.Session;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Transaction;

public class SessionDaoImpl implements SessionDao {

    private org.hibernate.Session currentSession;
    private Transaction currentTransaction;

    public org.hibernate.Session openCurrentSession(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public org.hibernate.Session openCurrentSessionWithTransaction(){
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

    private org.hibernate.Session getCurrentSession(){
        return currentSession;
    }
    public void setCurrentSession(org.hibernate.Session currentSession){
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction(){
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction){
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void insert(Session session) {

    }

    @Override
    public void update(Session session) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Session findById(long id) {
        return null;
    }
}
