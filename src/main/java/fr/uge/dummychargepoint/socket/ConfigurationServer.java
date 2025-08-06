package fr.uge.dummychargepoint.socket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetSocketAddress;
import java.util.Objects;

public class ConfigurationServer extends WebSocketServer {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationServer.class);

  private WebSocket client;
  private final Object lock = new Object();

  public ConfigurationServer(InetSocketAddress address) {
    super(address);
  }

  @Override
  public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
    Objects.requireNonNull(webSocket);
    Objects.requireNonNull(clientHandshake);
    synchronized (lock) {
      if (client != null) {
        webSocket.closeConnection(1, "Server is busy.");
        return;
      }
      var remote = webSocket.getRemoteSocketAddress();
      LOGGER.info("New connection to: {}", remote);
      client = webSocket;
    }
  }

  @Override
  public void onClose(WebSocket webSocket, int code, String reason, boolean remote) {
    Objects.requireNonNull(webSocket);
    synchronized (lock) {
      LOGGER.warn("closed {} with exit code {} and: {}",
        webSocket.getRemoteSocketAddress(),
        code,
        reason);
      if (webSocket.equals(client)) {
        client = null;
      }
    }
  }

  @Override
  public void onMessage(WebSocket webSocket, String message) {
    Objects.requireNonNull(webSocket);
    Objects.requireNonNull(message);
    synchronized (lock) {
      LOGGER.info("Received message from {}: {}", webSocket.getRemoteSocketAddress(), message);
    }
  }

  @Override
  public void onError(WebSocket webSocket, Exception exception) {
    synchronized (lock) {
      LOGGER.error("error: ", exception);
    }
  }

  @Override
  public void onStart() {
    synchronized (lock) {
      client = null;
      LOGGER.info("Websocket server started");
    }
  }
}
