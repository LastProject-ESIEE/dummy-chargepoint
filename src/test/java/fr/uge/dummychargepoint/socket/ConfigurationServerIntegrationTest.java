package fr.uge.dummychargepoint.socket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationServerIntegrationTest {

  private static final int RANDOM_PORT = 0;

  private ConfigurationServer server;

  @BeforeEach
  void start() throws InterruptedException {
    server = new ConfigurationServer(new InetSocketAddress(RANDOM_PORT));
    server.start();
    Thread.sleep(500);
  }

  @AfterEach
  void stop() throws InterruptedException {
    server.stop();
  }

  @Test
  void should_accept_client_connection() throws URISyntaxException, InterruptedException {
    // given
    var serverUri = new URI("ws://localhost:" + server.getPort());
    var client = new MockWebSocketClient(serverUri, Map.of());

    // when
    var connected = client.connectBlocking();

    // then
    assertThat(connected).isTrue();
    assertThat(server.getConnections()).hasSize(1);
  }

  @Test
  void should_accept_only_one_connection() throws URISyntaxException, InterruptedException {
    // given
    var serverUri = new URI("ws://localhost:" + server.getPort());
    var client = new MockWebSocketClient(serverUri, Map.of());
    var secondClient = new MockWebSocketClient(serverUri, Map.of());

    // when
    var connected = client.connectBlocking();
    var secondConnected = secondClient.connectBlocking();

    // then
    assertThat(connected).isTrue();
    assertThat(secondConnected).isFalse();
    assertThat(server.getConnections()).hasSize(1);
  }

  @Test
  void should_accept_connection_after_disconnection() throws URISyntaxException, InterruptedException {
    // given
    var serverUri = new URI("ws://localhost:" + server.getPort());
    var client = new MockWebSocketClient(serverUri, Map.of());
    var secondClient = new MockWebSocketClient(serverUri, Map.of());

    // when
    var connected = client.connectBlocking();
    assertThat(connected).isTrue();
    client.closeBlocking();
    var secondConnected = secondClient.connectBlocking();

    // then
    assertThat(secondConnected).isTrue();
    assertThat(server.getConnections()).hasSize(1);
  }

}
