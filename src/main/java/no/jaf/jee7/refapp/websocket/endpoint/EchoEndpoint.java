package no.jaf.jee7.refapp.websocket.endpoint;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;

@ServerEndpoint("/echo")
public class EchoEndpoint {

    private Session session;

    @OnOpen
    public void connect(Session session) {
        this.session = session;
    }

    @OnClose
    public void close() {
        this.session = null;
    }

    @OnMessage
    public void onMessage(String msg) {
        session.getAsyncRemote().sendText("Echo: " + msg);
    }
}
