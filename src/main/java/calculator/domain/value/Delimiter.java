package calculator.domain.value;


import calculator.error.ErrorMessage;

public class Delimiter {

  private static final int SINGLE_CHARACTER_LENGTH = 1;
  private static final String DIGIT_REGEX = "\\d";
  private static final String NON_WORD_CHARACTER_REGEX = "\\W";

  private final String value;

  public Delimiter(String value) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_DELIMITER);
    }
    if (value.length() != SINGLE_CHARACTER_LENGTH) {
      throw new IllegalArgumentException(ErrorMessage.SINGLE_CHARACTER_DELIMITER);
    }
    if (value.matches(DIGIT_REGEX)) {
      throw new IllegalArgumentException(ErrorMessage.DIGIT_NOT_ALLOWED_IN_DELIMITER);
    }
    this.value = escapeIfSpecialCharacter(value);
  }

  private String escapeIfSpecialCharacter(String value) {
    if (value.matches(NON_WORD_CHARACTER_REGEX)) {
      return "\\" + value;
    }
    return value;
  }

  public String toRegex() {
    return value;
  }
}