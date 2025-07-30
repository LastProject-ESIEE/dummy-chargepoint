package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageResponse;
import fr.uge.dummychargepoint.ocpp.ocpp16.data.ConfigurationStatus;
import java.util.Objects;

/**
 * Sent by the chargepoint after a {@link ChangeConfigurationRequest}.
 *
 * @param status The current status of the change.<br>
 *               If the key has been accepted or not.
 */
public record ChangeConfigurationResponse(ConfigurationStatus status) implements OcppMessageResponse {

  /**
   * {@link ChangeConfigurationResponse}'s constructor.
   *
   * @param status The current status of the change.<br>
   *               If the key has been accepted or not.
   */
  public ChangeConfigurationResponse {
    Objects.requireNonNull(status);
  }

}
