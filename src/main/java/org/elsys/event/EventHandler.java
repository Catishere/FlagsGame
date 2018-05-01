package org.elsys.event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.elsys.entity.User;
import org.elsys.helper.UserSockets;
import org.elsys.service.UserService;
import org.java_websocket.WebSocket;

public class EventHandler {
    private UserService userSvc = new UserService();

    public String executeEvent(WebSocket conn, String message) {

        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();

        String event = jsonObject.get("type").getAsString();

        switch (event) {
            case "login":
                return loginEvent(conn, jsonObject);
            case "googleLogin":
                return loginGoogleEvent(conn, jsonObject.get("userData").getAsJsonObject());
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

    private String loginGoogleEvent(WebSocket conn, JsonObject jsonObject) {
        String googleToken = jsonObject.get("idToken").getAsString();
        //User user = userSvc.getUserByGoogleID(googleToken);
        //if (user == null) {
            User user = userSvc.register(jsonObject.get("name").getAsString(),
                    null, null, googleToken,
                    jsonObject.get("email").getAsString(),
                    jsonObject.get("image").getAsString());
        //}
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
        return gson.toJson(user);
    }

    private String startGameEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private String forfeitEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private String answerEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private String searchMatchEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private String logoutEvent(WebSocket conn, JsonObject jsonObject) {
        return null;
    }

    private String loginEvent(WebSocket conn, JsonObject jsonObject) {

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
        return jsonObject.getAsString();
    }
}
