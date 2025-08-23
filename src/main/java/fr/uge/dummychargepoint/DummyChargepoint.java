package fr.uge.dummychargepoint;

import fr.uge.dummychargepoint.exception.IllegalTypeException;
import fr.uge.dummychargepoint.input.Type;
import fr.uge.dummychargepoint.socket.ConfigurationClient;
import fr.uge.dummychargepoint.socket.ConfigurationServer;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyChargepoint {

  private static final int ERROR_CODE = 1;
  private static final Logger LOGGER = LoggerFactory.getLogger(DummyChargepoint.class);

  public static void main(String[] args) throws URISyntaxException, InterruptedException {
    try {
      switch (Type.fromString(args[0])) {
        case Type.SERVER -> handleServer(args);
        case Type.CLIENT -> handleClient(args);
      }
    } catch (IllegalTypeException e) {
      LOGGER.error(e.getMessage());
      usage();
      System.exit(ERROR_CODE);
    } catch (ArrayIndexOutOfBoundsException e) {
      LOGGER.error("Missing arguments");
      usage();
      System.exit(ERROR_CODE);
    }
  }

  private static void handleClient(String[] args) throws URISyntaxException, InterruptedException {
    if (args.length < 3) {
      LOGGER.error("Not enough arguments for client, expected 3 arguments.");
      usage();
      System.exit(ERROR_CODE);
    }

    var remoteHost = args[1];
    var remotePort = Integer.parseInt(args[2]);
    var application = new ConfigurationClient(new URI("ws://" + remoteHost + ":" + remotePort), Map.of());
    application.connectBlocking();
  }

  private static void handleServer(String[] args) {
    if (args.length < 2) {
      LOGGER.error("Not enough arguments, expected at least 2.");
      usage();
      System.exit(ERROR_CODE);
    }

    var port = Integer.parseInt(args[1]);
    var application = new ConfigurationServer(new InetSocketAddress(port));
    application.start();
  }

  private static void usage() {
    System.out.println("Server: SERVER <local port>");
    System.out.println("Client: CLIENT <remote address> <remote port>");
  }

}