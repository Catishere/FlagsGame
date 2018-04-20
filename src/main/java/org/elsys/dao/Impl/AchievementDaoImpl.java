package org.elsys.dao.Impl;

import org.elsys.dao.AchievementDao;
import org.elsys.entity.Achievement;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AchievementDaoImpl implements AchievementDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public void openCurrentSessionWithTransaction(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
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
    public void insert(Achievement achievement) {
        getCurrentSession().save(achievement);
    }

    @Override
    public void update(Achievement achievement) {
        getCurrentSession().save(achievement);
    }

    @Override
    public void delete(long id) {
        getCurrentSession().delete(id);
    }

    @Override
    public Achievement findById(long id) {
        return null;
    }

    @Override
    public Achievement findByName(String name) {
        return null;
    }
}
