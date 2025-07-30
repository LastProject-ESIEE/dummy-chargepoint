package fr.uge.dummychargepoint.ocpp;

public enum MessageType {

  REQUEST(2),
  RESPONSE(3),
  ERROR(4);

  private final int callType;

  MessageType(int callType) {
    this.callType = callType;
  }

  public int getCallType() {
    return callType;
  }

  public static MessageType from(int callType) {
    for (var messageType : MessageType.values()) {
      if (messageType.callType == callType) {
        return messageType;
      }
    }
    throw new IllegalArgumentException("Unknown call type: " + callType);
  }

}
