package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageRequest;
import fr.uge.dummychargepoint.ocpp.ocpp16.data.FirmwareStatus;
import java.util.Objects;

/**
 * Packet sent by the machine to describe the current state of the firmware download.<br>
 * The server should respond by a {@link FirmwareStatusNotificationResponse}.
 *
 * @param status {@link FirmwareStatus}.
 */
public record FirmwareStatusNotificationRequest(FirmwareStatus status) implements OcppMessageRequest {

  /**
   * {@link FirmwareStatusNotificationRequest}'s constructor.
   *
   * @param status {@link FirmwareStatus}.
   */
  public FirmwareStatusNotificationRequest {
    Objects.requireNonNull(status);
  }

}
