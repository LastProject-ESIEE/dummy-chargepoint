package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageRequest;
import java.util.Objects;

/**
 * Represents the Update Firmware packet from OCPP 1.6.<br>
 * It should be answered by a {@link UpdateFirmwareResponse}.
 *
 * @param location The URL of the firmware, it will be used by the machine
 *                 to download the firmware.
 * @param retrieveDate The date which the machine will download the firmware.
 */
public record UpdateFirmwareRequest(String location, String retrieveDate) implements OcppMessageRequest {

  /**
   * {@link UpdateFirmwareRequest}'s constructor.
   *
   * @param location The URL of the firmware, it will be used by the machine
   *                 to download the firmware.
   * @param retrieveDate The date which the machine will download the firmware.
   */
  public UpdateFirmwareRequest {
    Objects.requireNonNull(location);
    Objects.requireNonNull(retrieveDate);
  }

}
