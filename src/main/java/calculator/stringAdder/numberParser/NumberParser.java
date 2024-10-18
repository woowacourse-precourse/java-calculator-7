package calculator.stringAdder.numberParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 17.
 */
public class NumberParser {
  private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");

  public String[] getNumbers(String input, String[] delimiters) {
    String numberString =
        delimiters.length == 2?
            input : input.substring(5);

    String regex = Arrays.stream(delimiters)
        .map(Pattern::quote)
        .collect(Collectors.joining("|"));

    return Arrays.stream(numberString.split(regex))
        .filter(s -> !s.isEmpty())
        .peek(this::validateNumber)
        .toArray(String[]::new);
  }

  private void validateNumber(String number) {
    if (number.startsWith("-")) {
      throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": 음수는 허용되지 않습니다: " + number);
    }
    if (number.contains(".")){
      throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": 소수는 허용되지 않습니다: " + number);
    }
    if (!NUMBER_PATTERN.matcher(number).matches()){
      throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": 유효하지 않은 숫자 형식 입니다.: " + number);
    }
  }
}
