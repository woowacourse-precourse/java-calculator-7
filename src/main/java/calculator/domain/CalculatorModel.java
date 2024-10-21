package calculator.domain;

import calculator.util.CalculatorUtils;
import java.util.regex.Pattern;

public class CalculatorModel {

  private static final String DEFAULT_DELIMITER = ",|:";

  public double sum(String input) {
    if (input.isBlank()) {
      return 0;
    }

    String seperator = DEFAULT_DELIMITER;
    // 커스텀 구분자 지정한 경우
    if (input.startsWith("//")) {
      String customSeparator = CalculatorUtils.extractCustomSeparator(input);
      seperator = DEFAULT_DELIMITER + "|" + Pattern.quote(customSeparator);
      input = input.substring(input.indexOf("\\n") + 2);
    }

    if (seperator.matches("[.\\\\+*?\\[\\](){}|^$]")) {
      seperator = Pattern.quote(seperator);
    }

    String[] numbers = input.split(seperator);

    if (numbers.length == 0) {
      return 0;
    }
    return CalculatorUtils.calculateSum(numbers);
  }
}
