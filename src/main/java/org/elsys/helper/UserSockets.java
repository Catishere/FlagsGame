package org.elsys.helper;

import org.java_websocket.WebSocket;

import java.util.HashMap;
import java.util.Map;

public class UserSockets {

    private static UserSockets ourInstance = new UserSockets();

    private Map<Long, WebSocket> userSockets = new HashMap<Long, WebSocket>();

    public static UserSockets getInstance() {
        return ourInstance;
    }

    private UserSockets() {
    }

    public void add(Long userId, WebSocket socket) {
        userSockets.put(userId, socket);
    }

    public void remove(WebSocket socket) {
        userSockets.values().remove(socket);
    }

    public WebSocket getSocket(Long userId) {
        return userSockets.get(userId);
    }

    public Long getUserId(WebSocket socket) {
        for (Map.Entry<Long, WebSocket> e : userSockets.entrySet()) {
            if (socket.equals(e.getValue()))
                return e.getKey();
        }
        return null;
    }
}