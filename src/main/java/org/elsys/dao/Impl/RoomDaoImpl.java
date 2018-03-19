package org.elsys.dao.Impl;

import org.elsys.dao.RoomDao;
import org.elsys.entity.Room;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomDaoImpl implements RoomDao {

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
    public void insert(Room user) {

    }

    @Override
    public void update(Room user) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Room findById(long id) {
        return null;
    }

    @Override
    public Room findByOwner(String owner) {
        return null;
    }
}
