package fr.uge.dummychargepoint.socket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class MockWebSocketServer extends WebSocketServer {

  public MockWebSocketServer(InetSocketAddress address) {
    super(address);
  }

  @Override
  public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

  }

  @Override
  public void onClose(WebSocket webSocket, int i, String s, boolean b) {

  }

  @Override
  public void onMessage(WebSocket webSocket, String s) {

  }

  @Override
  public void onError(WebSocket webSocket, Exception e) {

  }

  @Override
  public void onStart() {

  }

}
