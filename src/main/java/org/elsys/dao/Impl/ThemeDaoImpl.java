package org.elsys.dao.Impl;

import org.elsys.dao.ThemeDao;
import org.elsys.entity.Theme;
import org.elsys.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ThemeDaoImpl implements ThemeDao{

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
    public void insert(Theme theme) {
        getCurrentSession().save(theme);
    }

    @Override
    public void update(Theme theme) {
        getCurrentSession().save(theme);
    }

    @Override
    public void delete(long id) {
        getCurrentSession().delete(findById(id));
    }

    @Override
    public Theme findById(long id) {
        return getCurrentSession().get(Theme.class, id);
    }

    @Override
    public Theme findByName(String name) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Theme> query = builder.createQuery(Theme.class);
        Root<Theme> root = query.from(Theme.class);
        query.select(root).where(builder.equal(root.get("theme_name"), name));
        Query<Theme> q = getCurrentSession().createQuery(query);
        return q.getSingleResult();
    }
}
