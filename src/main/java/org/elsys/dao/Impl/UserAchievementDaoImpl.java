package org.elsys.dao.Impl;

import org.elsys.dao.UserAchievementDao;
import org.elsys.entity.RoomUser;
import org.elsys.entity.Theme;
import org.elsys.entity.UserAchievement;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserAchievementDaoImpl implements UserAchievementDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public void openCurrentSession(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
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
    public void insert(UserAchievement userAchievement) {
        getCurrentSession().save(userAchievement);
    }

    @Override
    public void update(UserAchievement userAchievement) {
        getCurrentSession().save(userAchievement);
    }

    @Override
    public void delete(long id) {
        getCurrentSession().delete(findById(id));
    }

    @Override
    public UserAchievement findById(long id) {
        return getCurrentSession().get(UserAchievement.class,id);
    }

    @Override
    public List<UserAchievement> findByUserId(long id) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserAchievement> query = builder.createQuery(UserAchievement.class);
        Root<UserAchievement> root = query.from(UserAchievement.class);
        query.select(root).where(builder.equal(root.get("user_id"), id));
        Query<UserAchievement> q = getCurrentSession().createQuery(query);
        return q.getResultList();
    }
}
