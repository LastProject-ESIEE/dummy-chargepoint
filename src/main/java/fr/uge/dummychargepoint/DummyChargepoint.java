package fr.uge.dummychargepoint;

import fr.uge.dummychargepoint.input.Type;
import fr.uge.dummychargepoint.socket.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URISyntaxException;
import java.util.Locale;

public class DummyChargepoint {

  private static final int ERROR_CODE = 1;
  private static final Logger LOGGER = LoggerFactory.getLogger(DummyChargepoint.class);

  public static void main(String[] args) throws URISyntaxException, InterruptedException {
    if (args.length < 2) {
      LOGGER.error("Not enough arguments, expected at least 2.");
      usage();
      System.exit(ERROR_CODE);
    }
    switch (Type.valueOf(args[0].toUpperCase(Locale.ROOT))) {
      case Type.SERVER -> {
        var port = Integer.parseInt(args[1]);
        var application = new Application(port);
        application.start();
      }
      case Type.CLIENT -> {
        if (args.length < 4) {
          LOGGER.error("Not enough arguments for client, expected 4 arguments.");
          usage();
          System.exit(ERROR_CODE);
        }
        var remoteHost = args[1];
        var remotePort = Integer.parseInt(args[2]);
        var localPort = Integer.parseInt(args[3]);
        var application = new Application(remoteHost, remotePort, localPort);
        application.connectBlocking();
      }
      default -> {
        LOGGER.error("Wrong type given, must be CLIENT or SERVER.");
        usage();
        System.exit(ERROR_CODE);
      }
    }
  }

  private static void usage() {
    System.out.println("Server: SERVER <local port>");
    System.out.println("Client: CLIENT <remote address> <remote port> <local port>");
  }

}