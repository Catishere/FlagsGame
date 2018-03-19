package org.elsys.dao;

import org.elsys.entity.Session;

public interface SessionDao {
    void insert(Session session);
    void update(Session session);
    void delete(long id);
    Session findById(long id);
}
