package fr.uge.dummychargepoint.ocpp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTypeTest {

  @Test
  public void should_return_unknown() {
    // given
    var code = 10;

    // when
    var messageType = MessageType.from(code);

    // then
    assertThat(messageType).isEqualTo(MessageType.UNKNOWN);
  }

}