package fr.uge.dummychargepoint.socket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetSocketAddress;
import java.util.Objects;

public class ConfigurationServer extends WebSocketServer implements ConfigurationApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationServer.class);

  public ConfigurationServer(InetSocketAddress address) {
    super(address);
  }

  @Override
  public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
    Objects.requireNonNull(webSocket);
    Objects.requireNonNull(clientHandshake);
    var remote = webSocket.getRemoteSocketAddress();
    LOGGER.info("New connection to: {}", remote);
  }

  @Override
  public void onClose(WebSocket webSocket, int code, String reason, boolean remote) {
    Objects.requireNonNull(webSocket);
    LOGGER.warn("closed {} with exit code {} and: {}",
      webSocket.getRemoteSocketAddress(),
      code,
      reason);
    webSocket.close();
  }

  @Override
  public void onMessage(WebSocket webSocket, String message) {
    Objects.requireNonNull(webSocket);
    Objects.requireNonNull(message);
    LOGGER.info("Received message from {}: {}", webSocket.getRemoteSocketAddress(), message);
  }

  @Override
  public void onError(WebSocket webSocket, Exception exception) {
    LOGGER.error("error: ", exception);
  }

  @Override
  public void onStart() {
    LOGGER.info("Websocket server started");
  }
}
