package fr.uge.dummychargepoint.socket;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

class ConfigurationClientIntegrationTest {

  private static final int PORT = 8887;

  private static MockWebSocketServer server;

  @BeforeAll
  static void startServer() throws InterruptedException {
    server = new MockWebSocketServer(new InetSocketAddress(PORT));
    server.start();
    Thread.sleep(500);
  }

  @AfterAll
  static void stopServer() throws InterruptedException {
    server.stop();
  }

  @Test
  void should_connect_to_server() throws URISyntaxException, InterruptedException {
    // given
    var serverUri = new URI("ws://localhost:" + PORT);
    var client = new ConfigurationClient(serverUri, Map.of());

    // when
    var connected = client.connectBlocking();

    // then
    assertThat(connected).isTrue();
  }



}
