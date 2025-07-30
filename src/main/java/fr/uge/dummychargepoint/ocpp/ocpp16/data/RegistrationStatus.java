package fr.uge.dummychargepoint.ocpp.ocpp16.data;

/**
 * Defines the status given to a message.<br>
 * It can be :<br>
 * - Accepted, the message has been accepted ;<br>
 * - Pending, the message is waiting for rejection or acceptance ;<br>
 * - Rejected, the message has been rejected.
 */
public enum RegistrationStatus {

  ACCEPTED("Accepted"),
  PENDING("Pending"),
  REJECTED("Rejected");

  private final String status;

  RegistrationStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}