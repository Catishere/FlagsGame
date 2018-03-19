package org.elsys.dao;

import org.elsys.entity.Room;

public interface RoomDao {
    void insert(Room user);
    void update(Room user);
    void delete(long id);
    Room findById(long id);
    Room findByOwner (String owner);
}
