package calculator.util;

public class CalculatorUtils {

  public static int calculateSum(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      int addNum = Integer.parseInt(number);
      if (addNum < 0) {
        throw new IllegalArgumentException("음수는 넣을 수 없습니다.");
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
    return input.substring(2, separatorIndex);
  }
}
