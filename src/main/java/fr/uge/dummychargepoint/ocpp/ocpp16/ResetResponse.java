package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageResponse;
import fr.uge.dummychargepoint.ocpp.ocpp16.data.RegistrationStatus;
import java.util.Objects;

/**
 * Confirms if the {@link ResetRequest} has been accepted or not.<br>
 * It should be sent after a {@link ResetRequest}.
 *
 * @param status {@link RegistrationStatus}.
 */
public record ResetResponse(RegistrationStatus status) implements OcppMessageResponse {

  /**
   * {@link ResetResponse}'s constructor.
   *
   * @param status {@link RegistrationStatus}.
   */
  public ResetResponse {
    Objects.requireNonNull(status);
  }

}
