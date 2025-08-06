package fr.uge.dummychargepoint.socket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.util.Map;

public class MockWebSocketClient extends WebSocketClient {

  public MockWebSocketClient(URI serverAddress, Map<String, String> httpHeaders) {
    super(serverAddress, httpHeaders);
  }

  @Override
  public void onOpen(ServerHandshake serverHandshake) {

  }

  @Override
  public void onMessage(String s) {

  }

  @Override
  public void onClose(int i, String s, boolean b) {

  }

  @Override
  public void onError(Exception e) {

  }

}
