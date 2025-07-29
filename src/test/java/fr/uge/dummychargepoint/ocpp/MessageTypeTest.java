package fr.uge.dummychargepoint.ocpp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MessageTypeTest {

  @Test
  void should_return_unknown() {
    // given
    var code = 10;

    // when
    var messageType = MessageType.from(code);

    // then
    assertThat(messageType).isEqualTo(MessageType.UNKNOWN);
  }

  @ParameterizedTest
  @MethodSource("provideCorrectEnum")
  void should_return_correct_enum(int callType, MessageType expected) {
    // given
    // Here we have the callType parameter which we are going to use below
    // when
    var messageType = MessageType.from(callType);

    // then
    assertThat(messageType).isEqualTo(expected);
  }

  private static Stream<Arguments> provideCorrectEnum() {
    return Stream.of(
      Arguments.of(2, MessageType.REQUEST),
      Arguments.of(3, MessageType.RESPONSE),
      Arguments.of(-1, MessageType.UNKNOWN)
    );
  }

}