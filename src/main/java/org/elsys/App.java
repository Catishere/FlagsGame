package org.elsys;

import org.elsys.entity.Achievement;
import org.elsys.server.SocketServer;
import org.elsys.service.AchievementService;
import org.java_websocket.WebSocketImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main( String[] args ) throws IOException, InterruptedException {
        WebSocketImpl.DEBUG = true;
        int port = 8080;
        if (args.length != 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception ex) {
                System.out.println("Riperoni");
            }
        }

        SocketServer server = new SocketServer( port );

        server.start();
        System.out.println("Socket Server started on port: " + server.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            server.sendToAll(in);
            if (in.equals("exit")) {
                server.stop();
                break;
            }
            if (in.equals("count")) {
                System.out.println(server.getSocketCount());
            }
        }
    }
}
