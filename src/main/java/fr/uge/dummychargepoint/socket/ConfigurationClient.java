package fr.uge.dummychargepoint.socket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.util.Map;

public class ConfigurationClient extends WebSocketClient implements ConfigurationApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationClient.class);

  public ConfigurationClient(URI serverUri, Map<String, String> httpHeaders) {
    super(serverUri, httpHeaders);
  }

  @Override
  public void onOpen(ServerHandshake serverHandshake) {
    LOGGER.info("Connected to server: {}", getURI());
    sendMessage("Hello world :)");
  }

  @Override
  public void onMessage(String message) {
    LOGGER.info("Received message: {}", message);
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
    LOGGER.warn("Connection closed. Code: {}, Reason: {}, Remote: {}", code, reason, remote);
  }

  @Override
  public void onError(Exception exception) {
    LOGGER.error("WebSocket error", exception);
  }

  public void sendMessage(String message) {
    if (this.isOpen()) {
      send(message);
      LOGGER.info("Sent message: {}", message);
    } else {
      LOGGER.warn("Cannot send message. Connection is not open.");
    }
  }

  @Override
  public void start() {
    throw new UnsupportedOperationException("Client cannot start a server.");
  }
}
