package no.jaf.jee7.refapp.websocket.endpoint;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import java.io.IOException;

@ServerEndpoint("/echo")
public class EchoEndpoint {

    private Session session;

    @OnOpen
    public void connect(Session session) {
        this.session = session;
        System.out.println(session);
    }

    @OnClose
    public void close() {
        this.session = null;
        System.out.println("Closed");
    }

    @OnMessage
    public void onMessage(String msg) {
        System.out.println("Msg: " + msg);
        session.getAsyncRemote().sendText("Echo: " + msg);
    }
}
