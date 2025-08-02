package fr.uge.dummychargepoint.input;

import java.util.Scanner;
import java.util.logging.Logger;

public class Terminal {

  private static final Logger LOGGER = Logger.getLogger(Terminal.class.getName());

  public void run() {
    try (var scanner = new Scanner(System.in)) {
      while (scanner.hasNextLine() && !Thread.interrupted()) {
        var message = scanner.nextLine();
        LOGGER.info(message);
      }
    }
  }
}
