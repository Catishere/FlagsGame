package org.elsys.dao.Impl;

import org.elsys.dao.FlagDao;
import org.elsys.entity.Flag;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FlagDaoImpl implements FlagDao {

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
    public void insert(Flag flag) {
        getCurrentSession().save(flag);
    }

    @Override
    public void update(Flag flag) {
        getCurrentSession().save(flag);
    }

    @Override
    public void delete(long id) {
        getCurrentSession().save(findById(id));
    }

    @Override
    public Flag findById(long id) {
        return null;
    }

    @Override
    public Flag findByName(String name) {
        return null;
    }
}
