package calculator.domain;

import calculator.util.CalculatorUtils;
import java.util.regex.Pattern;

public class CalculatorModel {

  private static final String DEFAULT_DELIMITER = ",|:";

  public int sum(String input) {
    if (input.isBlank()) {
      return 0;
    }

    String seperator = DEFAULT_DELIMITER;

    // 커스텀 구분자 지정한 경우
    if (input.startsWith("//")) {
      seperator = CalculatorUtils.extractCustomSeparator(input);
      input = input.substring(input.indexOf("\\n") + 2);
    }

    if (seperator.matches("[.\\\\+*?\\[\\](){}|^$]")) {
      seperator = Pattern.quote(seperator);
    }

    String[] numbers = input.split(seperator);
    return CalculatorUtils.calculateSum(numbers);
  }
}
