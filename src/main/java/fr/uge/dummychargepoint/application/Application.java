package fr.uge.dummychargepoint.application;

import fr.uge.dummychargepoint.input.Terminal;

public class Application {

  private final Thread consoleThread;

  public Application() {
    var terminal = new Terminal();
    consoleThread = Thread.ofPlatform().daemon().unstarted(terminal::run);
  }

  public void launch() {
    consoleThread.start();
    while (!Thread.interrupted()) {
      for (;;) {
      }
    }
  }

}
