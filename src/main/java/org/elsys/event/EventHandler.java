package org.elsys.event;

import org.elsys.dao.RoomUserDao;
import org.elsys.entity.User;
import org.elsys.helper.UserSockets;
import org.elsys.service.RoomService;
import org.elsys.service.UserService;
import org.java_websocket.WebSocket;
import org.json.JSONObject;

public class EventHandler {
    private UserService userSvc = new UserService();
    private RoomService roomService = new RoomService();

    public JSONObject executeEvent(WebSocket conn, JSONObject jsonObject) {

        String event = jsonObject.get("event").toString();

        switch (event) {
            case "login":
                return loginEvent(conn, jsonObject);
            case "logout":
                return logoutEvent(conn, jsonObject);
            case "searchMatch":
                return searchMatchEvent(conn, jsonObject);
            case "answer":
                return answerEvent(conn, jsonObject);
            case "forfeit":
                return forfeitEvent(conn, jsonObject);
            case "startGame":
                return startGameEvent(conn, jsonObject);

            default:
                return null;
        }
    }

    private JSONObject startGameEvent(WebSocket conn, JSONObject jsonObject) {
        return null;
    }

    private JSONObject forfeitEvent(WebSocket conn, JSONObject jsonObject) {
        return null;
    }

    private JSONObject answerEvent(WebSocket conn, JSONObject jsonObject) {
        return null;
    }

    private JSONObject searchMatchEvent(WebSocket conn, JSONObject jsonObject) {
        return null;
    }

    private JSONObject logoutEvent(WebSocket conn, JSONObject jsonObject) {
        return null;
    }

    private JSONObject loginEvent(WebSocket conn, JSONObject jsonObject) {

        String name = (String) jsonObject.get("user");
        String pass = (String) jsonObject.get("pass");
        User user = userSvc.getUserByName(name);

        if (user != null) {
            if (user.getPassword().equals(pass)) {
                jsonObject.put("success", true);
                UserSockets.getInstance().add(user.getId(), conn);
                jsonObject.put("userId", user.getId());
            } else {
                jsonObject.put("success", false);
            }
        } else {
            jsonObject.put("success", false);
        }
        jsonObject.remove("pass");
        return new JSONObject().put("login", jsonObject);
    }
}
