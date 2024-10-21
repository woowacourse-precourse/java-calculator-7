package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CaculatorModel {

  public String input;
  private static final String DEFAULT_DELIMITER = ",|:";

  public CaculatorModel(String input) {
    this.input = input;
  }


  public int sum() {
    if (input.isBlank()) {
      return 0;
    }

    String seperator = DEFAULT_DELIMITER;

    // 커스텀 구분자 지정한 경우
    if (input.startsWith("//")) {
      int seperatorIndex = input.indexOf("\n");
      if (seperatorIndex == -1) {
        throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
      }
      seperator = input.substring(2, seperatorIndex);
      input = input.substring(seperatorIndex + 1);
    }

    if (seperator.matches("[.\\\\+*?\\[\\](){}|^$]")) {
      seperator = Pattern.quote(seperator);
    }

    String[] numbers = input.split(seperator);
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

  public void printResult(int result) {
    System.out.println("결과: " + result);
  }
}
