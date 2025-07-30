package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageResponse;
import fr.uge.dummychargepoint.ocpp.ocpp16.data.RegistrationStatus;
import java.util.Objects;

/**
 * Defines a response to the BootNotificationRequest.<br>
 * See this as an ACK packet.
 *
 * @param currentTime The current server time of the server in String.
 * @param interval This value defines the interval in second that the remote should respect
 *                 before sending a HeartBeat packet (which is like a PING).
 * @param status This enum serves as a response for the message. If it is accepted,
 *               rejected or something else.
 */
public record BootNotificationResponse(String currentTime,
                                       int interval,
                                       RegistrationStatus status) implements OcppMessageResponse {


  /**
   * {@link BootNotificationResponse}'s constructor.
   *
   * @param currentTime The current server time of the server in String.
   * @param interval This value defines the interval in second that the remote should respect
   *                 before sending a HeartBeat packet (which is like a PING).
   * @param status This enum serves as a response for the message. If it is accepted,
   *               rejected or something else.
   */
  public BootNotificationResponse {
    Objects.requireNonNull(currentTime);
    Objects.requireNonNull(status);
  }
}