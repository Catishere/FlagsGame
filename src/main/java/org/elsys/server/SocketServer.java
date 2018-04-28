package org.elsys.server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;

public class SocketServer extends WebSocketServer {

    public SocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    public SocketServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send( "new connection: " + handshake.getResourceDescriptor() );
        System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " established connection to server" );
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message: " + message);
        Gson g = new Gson();
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String result = jsonObject.get("name").getAsString();
        System.out.println(result);
        conn.send(result);
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message ) {
        System.out.println(message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {

    }

    public void sendToAll(String text ) {
        Collection<WebSocket> con = connections();
        synchronized ( con ) {
            for( WebSocket c : con ) {
                c.send( text );
            }
        }
    }

    public int getSocketCount() {
        return connections().size();
    }
}
