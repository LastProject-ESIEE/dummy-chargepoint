package fr.uge.dummychargepoint.ocpp.ocpp16.data;

/**
 * Defines the status used in {@link fr.uge.dummychargepoint.ocpp.ocpp16.ChangeConfigurationResponse}.<br>
 * It is used to respond after a {@link fr.uge.dummychargepoint.ocpp.ocpp16.ChangeConfigurationRequest}
 * It can be :<br>
 * - Accepted, the change has been accepted ;<br>
 * - Rejected, the change has been rejected because the value is wrong ;<br>
 * - RebootRequired, the change has been accepted but the chargepoint needs to reboot ;<br>
 * - NotSupported, the given key is not correct.
 */
public enum ConfigurationStatus {

  ACCEPTED("Accepted"),
  REJECTED("Rejected"),
  REBOOT_REQUIRED("RebootRequired"),
  NOT_SUPPORTED("NotSupported");

  private final String status;

  ConfigurationStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
