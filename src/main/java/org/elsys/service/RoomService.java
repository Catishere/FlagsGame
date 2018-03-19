package org.elsys.service;

import org.elsys.dao.Impl.RoomDaoImpl;
import org.elsys.entity.Theme;

public class RoomService {

    private static RoomDaoImpl roomDao;

    public RoomService() {
        roomDao = new RoomDaoImpl();
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

    public Theme getTheme() {
        return null;
    }
}
