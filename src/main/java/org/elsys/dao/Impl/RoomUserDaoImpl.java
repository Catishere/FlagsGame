package org.elsys.dao.Impl;

import org.elsys.dao.RoomUserDao;
import org.elsys.entity.RoomUser;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RoomUserDaoImpl implements RoomUserDao {

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
    public void insert(RoomUser roomUser) {
        getCurrentSession().save(roomUser);
    }

    @Override
    public void update(RoomUser roomUser) {
        getCurrentSession().save(roomUser);
    }

    @Override
    public void delete(long id) {
        getCurrentSession().delete(findById(id));
    }

    @Override
    public RoomUser findById(long id) {
        return getCurrentSession().get(RoomUser.class,id);
    }


    @Override
    public List<RoomUser> findByRoomId(long id) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<RoomUser> query = builder.createQuery(RoomUser.class);
        Root<RoomUser> root = query.from(RoomUser.class);
        query.select(root).where(builder.equal(root.get("room_id"), id));
        Query<RoomUser> q = getCurrentSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<RoomUser> findByUserId(long id) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<RoomUser> query = builder.createQuery(RoomUser.class);
        Root<RoomUser> root = query.from(RoomUser.class);
        query.select(root).where(builder.equal(root.get("user_id"), id));
        Query<RoomUser> q = getCurrentSession().createQuery(query);
        return q.getResultList();
    }
}
