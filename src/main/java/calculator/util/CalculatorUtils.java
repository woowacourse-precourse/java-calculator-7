package calculator.util;

public class CalculatorUtils {

  public static double calculateSum(String[] numbers) {
    double sum = 0;
    for (String number : numbers) {
      double addNum = Double.parseDouble(number);
      if (addNum <= 0) {
        throw new IllegalArgumentException("음수나 0은 넣을 수 없습니다.");
      }
      sum += addNum;
    }
    return sum;
  }

  public static String extractCustomSeparator(String input) {
    int separatorIndex = input.indexOf("\\n");
    if (separatorIndex == -1) {
      throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
    }

    String customSeparator = input.substring(2, separatorIndex);

    if (customSeparator.matches("\\d")) {
      throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
    }

    if (customSeparator.length() > 1) {
      throw new IllegalArgumentException("구분자는 한 자리 문자만 가능합니다.");
    }

    return customSeparator;
  }
}
