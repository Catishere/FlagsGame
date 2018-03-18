package org.elsys.common.services;

public class RoomService {
    public void createRoom(int creatorId) {}

    public void joinRoom(int userId, int roomId) {}

    public void setAdmin(int userId, int roomId) {}

    public void startSession(int roomId) {}

    public void leaveRoom(int userId, int roomId) {}

    public boolean hasSession(int roomId) { return true; }

    public void setTheme() {}
}
