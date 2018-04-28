package org.elsys.event;

import com.google.gson.JsonObject;
import org.elsys.dao.RoomUserDao;
import org.elsys.entity.User;
import org.elsys.helper.UserSockets;
import org.elsys.service.RoomService;
import org.elsys.service.UserService;
import org.java_websocket.WebSocket;

public class EventHandler {
    private UserService userSvc = new UserService();
    private RoomService roomService = new RoomService();

    public JsonObject executeEvent(WebSocket conn, JsonObject jsonObject) {

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

    private JsonObject startGameEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private JsonObject forfeitEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private JsonObject answerEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private JsonObject searchMatchEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private JsonObject logoutEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private JsonObject loginEvent(WebSocket conn, JsonObject jsonObject) {

        String name = jsonObject.get("name").getAsString();
        String pass = jsonObject.get("pass").getAsString();
        User user = userSvc.getUserByName(name);

        if (user != null) {
            if (user.getPassword().equals(pass)) {
                jsonObject.addProperty("success", true);
                UserSockets.getInstance().add(user.getId(), conn);
                jsonObject.addProperty("userId", user.getId());
            } else {
                jsonObject.addProperty("success", false);
            }
        } else {
            jsonObject.addProperty("success", false);
        }
        jsonObject.remove("pass");
        jsonObject.addProperty("event", "login");
        return jsonObject;
    }
}
