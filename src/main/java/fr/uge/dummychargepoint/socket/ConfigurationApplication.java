package fr.uge.dummychargepoint.socket;

public interface ConfigurationApplication {

  void start();

  boolean connectBlocking() throws InterruptedException;

}
