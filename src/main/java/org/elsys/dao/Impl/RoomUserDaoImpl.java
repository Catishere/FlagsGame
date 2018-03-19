package org.elsys.dao.Impl;

import org.elsys.dao.RoomUserDao;
import org.elsys.entity.RoomUser;
import org.elsys.entity.SessionUser;

import java.util.List;

public class RoomUserDaoImpl implements RoomUserDao {
    @Override
    public void insert(RoomUser roomUser) {

    }

    @Override
    public void update(RoomUser roomUser) {

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
