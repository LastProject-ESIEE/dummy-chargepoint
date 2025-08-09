package fr.uge.dummychargepoint.exception;

public class IllegalTypeException extends RuntimeException {

  @SuppressWarnings("unused")
  public IllegalTypeException(String message) {
    super(message);
  }

  @SuppressWarnings("unused")
  public IllegalTypeException(String message, Throwable cause) {
    super(message, cause);
  }

  @SuppressWarnings("unused")
  public IllegalTypeException(Throwable cause) {
    super(cause);
  }
}
