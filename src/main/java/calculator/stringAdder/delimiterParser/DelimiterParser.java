package calculator.stringAdder.delimiterParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 16.
 */
public class DelimiterParser {
  private static final String[] DEFAULT_DELIMITERS = {",", ":"};
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)n(.*)");

  public String[] getDelimiters(String input) {
    if (input.startsWith("//")){
      Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
      if (matcher.matches()) {
        String[] customDelimiters = new String[]{ DEFAULT_DELIMITERS[0],
                                                      DEFAULT_DELIMITERS[1],
                                                      matcher.group(1)};
        return customDelimiters;
      }
      else {
        throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": 커스텀 구분자를 찾을 수 없습니다.");
      }
    }
    return DEFAULT_DELIMITERS;
  }
}
