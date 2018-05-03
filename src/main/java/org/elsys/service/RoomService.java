package org.elsys.service;

import org.elsys.dao.Impl.RoomDaoImpl;
import org.elsys.dao.Impl.RoomUserDaoImpl;
import org.elsys.entity.Room;
import org.elsys.entity.RoomUser;
import org.elsys.entity.Theme;
import org.elsys.entity.User;

import java.util.List;

public class RoomService {

    private static RoomDaoImpl roomDao;
    private static RoomUserDaoImpl roomUserDao;

    public RoomService() {
        roomDao = new RoomDaoImpl();
        roomUserDao = new RoomUserDaoImpl();
    }

    public void createRoom(long ownerId) {
    }

    public void joinRoom(long userId, long roomId) {

    }

    public void setAdmin(long userId, long roomId) {
    }

    public void startSession(long roomId) {
    }

    public void leaveRoom(long userId) {
    }

    public boolean hasSession(long roomId) {
        return true;
    }

    public void setTheme() {
    }

    public List<User> getUsersInRoom(long id) {
        return null;
    }

    public RoomUser getUserRoom(long userId) {
        roomUserDao.openCurrentSession();
        List<RoomUser> roomUsers = roomUserDao.findByUserId(userId);
        roomUserDao.closeCurrentSession();
        return roomUsers.get(0);
    }

    public Theme getTheme() {
        return null;
    }
}
