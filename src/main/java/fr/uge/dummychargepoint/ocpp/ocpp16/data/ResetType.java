package fr.uge.dummychargepoint.ocpp.ocpp16.data;

/**
 * Defines the status used in {@link fr.uge.dummychargepoint.ocpp.ocpp16.ResetRequest}.<br>
 * It can be :<br>
 * - Soft, the reboot will be done after all transactions are done ;<br>
 * - Hard, the reboot will be done as soon as possible.
 */
public enum ResetType {

  HARD("Hard"),
  SOFT("Soft");

  private final String type;

  ResetType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

}
