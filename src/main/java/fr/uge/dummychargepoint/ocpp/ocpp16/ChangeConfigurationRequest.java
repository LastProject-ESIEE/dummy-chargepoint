package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageRequest;
import java.util.Objects;

/**
 * Sent by the server to change a value of a chargepoint's key.<br>
 * It should be answered by a {@link ChangeConfigurationResponse}.
 *
 * @param key The element we want to change the value of.
 * @param value The value to be changed.
 */
public record ChangeConfigurationRequest(String key, String value) implements OcppMessageRequest {

  /**
   * {@link ChangeConfigurationRequest}'s constructor.
   *
   * @param key The element we want to change the value of.
   * @param value The value to be changed.
   */
  public ChangeConfigurationRequest {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    if (key.length() > 50) {
      throw new IllegalArgumentException("Key name cannot be longer than 50 characters.");
    }
    if (value.length() > 500) {
      throw new IllegalArgumentException("Value cannot be more than 500 characters.");
    }
  }

}
