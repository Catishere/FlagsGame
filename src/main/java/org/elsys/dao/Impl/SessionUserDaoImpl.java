package org.elsys.dao.Impl;

import org.elsys.dao.SessionUserDao;
import org.elsys.entity.SessionUser;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SessionUserDaoImpl implements SessionUserDao {

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
    public void insert(SessionUser sessionUser) {

    }

    @Override
    public void update(SessionUser sessionUser) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<SessionUser> findBySessionId(long id) {
        return null;
    }

    @Override
    public List<SessionUser> findByUserId(long id) {
        return null;
    }

    @Override
    public List<SessionUser> findByUsername(String name) {
        return null;
    }
}
