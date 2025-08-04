package fr.uge.dummychargepoint.socket;

public interface ConfigurationApplication {

  default void start() {
    throw new IllegalCallerException("Client cannot start a websocket connection");
  }

  default boolean connectBlocking() throws InterruptedException {
    throw new IllegalCallerException("Server cannot connect to another server");
  }

}
