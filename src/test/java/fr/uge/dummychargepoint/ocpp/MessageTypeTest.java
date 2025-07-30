package fr.uge.dummychargepoint.ocpp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MessageTypeTest {

  @Test
  void should_throw_an_error_on_unknown_code() {
    // given
    var code = 10;

    // when and then
    assertThatIllegalArgumentException().isThrownBy(() -> MessageType.from(code))
      .withMessage("Unknown call type: 10");
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

  @ParameterizedTest
  @MethodSource("provideCorrectEnum")
  void should_return_correct_call_type(int expected, MessageType messageType) {
    // given
    // Here we have the messageType parameter which we are going to use below

    // when
    var callType = messageType.getCallType();

    // then
    assertThat(callType).isEqualTo(expected);
  }

  private static Stream<Arguments> provideCorrectEnum() {
    return Stream.of(
      Arguments.of(2, MessageType.REQUEST),
      Arguments.of(3, MessageType.RESPONSE),
      Arguments.of(4, MessageType.ERROR)
    );
  }

}