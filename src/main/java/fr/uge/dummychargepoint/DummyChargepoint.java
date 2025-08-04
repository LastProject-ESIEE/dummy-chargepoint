package fr.uge.dummychargepoint;

import fr.uge.dummychargepoint.socket.Application;

import java.net.URISyntaxException;
import java.util.Locale;

public class DummyChargepoint {

  public static void main(String[] args) throws URISyntaxException, InterruptedException {
    if (args.length < 2) {
      throw new AssertionError();
    }
    switch (args[0].toUpperCase(Locale.ROOT)) {
      case "SERVER" -> {
        var port = Integer.parseInt(args[1]);
        var application = new Application(port);
        application.start();
      }
      case "CLIENT" -> {
        if (args.length < 4) {
          throw new AssertionError();
        }
        var remoteHost = args[1];
        var remotePort = Integer.parseInt(args[2]);
        var localPort = Integer.parseInt(args[3]);
        var application = new Application(remoteHost, remotePort, localPort);
        application.connectBlocking();
      }
    }
  }
}