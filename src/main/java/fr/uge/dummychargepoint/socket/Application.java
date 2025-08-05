package fr.uge.dummychargepoint.socket;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class Application {

  private final boolean isServer;
  private final ConfigurationApplication application;

  public Application(int port) {
    if (port < 1024) {
      throw new IllegalArgumentException("Port must be above 1024.");
    }
    isServer = true;
    application = new ConfigurationServer(new InetSocketAddress(port));
  }

  public Application(String remoteHost, int remotePort) throws URISyntaxException {
    isServer = false;
    var serverUri = new URI("ws://" + remoteHost + ":" + remotePort);
    application = new ConfigurationClient(serverUri, Map.of());
  }

  public void start() {
    if (isServer) {
      application.start();
    }
  }

  public void connectBlocking() throws InterruptedException {
    if (!isServer) {
      application.connectBlocking();
    }
  }

}
