package calculator.stringAdder.delimiterParser;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 16.
 */
public class DelimiterParser {
  private static final String[] DEFAULT_DELIMITERS = {",", ":"};
  private static final String CUSTOM_DELIMITER_PREFIX = "//";
  private static final int CUSTOM_DELIMITER_INDEX = 2;
  private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

  public String[] getDelimiters(String input) {
    if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)){
      return DEFAULT_DELIMITERS;
    }

    if (input.length() <= 3 || input.charAt(3) != CUSTOM_DELIMITER_SUFFIX.charAt(0)) {
      throw new IllegalArgumentException(this.getClass().getSimpleName() + ": 올바르지 않은 커스텀 구분자 설정입니다.");
    }

    if ( '0' <= input.charAt(CUSTOM_DELIMITER_INDEX) && input.charAt(CUSTOM_DELIMITER_INDEX) <= '9'){
      throw new IllegalArgumentException(this.getClass().getSimpleName() + ": 숫자는 구분자로 사용할 수 없습니다.");
    }

    String[] customDelimiters = new String[]{ DEFAULT_DELIMITERS[0],
                                              DEFAULT_DELIMITERS[1],
                                              String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX))};

    return customDelimiters;
  }
}
