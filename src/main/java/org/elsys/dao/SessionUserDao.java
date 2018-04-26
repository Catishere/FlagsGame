package org.elsys.dao;

import org.elsys.entity.RoomUser;
import org.elsys.entity.SessionUser;

import java.util.List;

public interface SessionUserDao {
    void insert(SessionUser sessionUser);
    void update(SessionUser sessionUser);
    void delete(long id);
    List<SessionUser> findBySessionId(long id);
    List<SessionUser> findByUserId(long id);
    SessionUser findById(long id);
}
