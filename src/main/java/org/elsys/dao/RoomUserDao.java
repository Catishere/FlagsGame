package org.elsys.dao;

import org.elsys.entity.Room;
import org.elsys.entity.RoomUser;
import org.elsys.entity.SessionUser;

import java.util.List;

public interface RoomUserDao {
    void insert(RoomUser roomUser);
    void update(RoomUser roomUser);
    void delete(long id);
    RoomUser findById(long id);
    List<RoomUser> findByRoomId(long id);
    List<RoomUser> findByUserId(long id);
}
