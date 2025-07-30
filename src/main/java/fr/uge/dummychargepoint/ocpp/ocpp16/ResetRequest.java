package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageRequest;
import fr.uge.dummychargepoint.ocpp.ocpp16.data.ResetType;
import java.util.Objects;

/**
 * A reset request sent by the server for the chargepoint.<br>
 * This request has a type which can be : Hard or Soft.<br>
 * Hard : Cancel every transaction and reboot.<br>
 * Soft : Finish every transaction and reboot.<br>
 * For now, we can use Hard reboot.<br>
 * It should be responded by a {@link ResetResponse} from the chargepoint.
 *
 * @param type The reboot type (Hard or Soft).
 */
public record ResetRequest(ResetType type) implements OcppMessageRequest {

  /**
   * {@link ResetRequest}'s constructor.
   *
   * @param type The reboot type (Hard or Soft).
   */
  public ResetRequest {
    Objects.requireNonNull(type);
  }

}
