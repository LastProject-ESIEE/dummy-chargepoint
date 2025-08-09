package fr.uge.dummychargepoint.input;

import fr.uge.dummychargepoint.exception.IllegalTypeException;
import java.util.Locale;

public enum Type {

  CLIENT, SERVER;

  public static Type fromString(String string) {
    try {
      return Type.valueOf(string.toUpperCase(Locale.ROOT));
    } catch (IllegalArgumentException e) {
      throw new IllegalTypeException("Wrong type given, must be CLIENT or SERVER.", e);
    }
  }
}
