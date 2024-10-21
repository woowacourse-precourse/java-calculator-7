package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public void run() {
    String input = readInput();
  }

  // 사용자 입력 받기
  private String readInput() {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    return Console.readLine();
  }

  // 입력 문자열에서 구분자를 추출하기
  private String getDelimiter(String userInput) {
    if (userInput.startsWith("//")) {
      int delimiterIndex = userInput.indexOf("\\n");
      if (delimiterIndex == -1) {
        throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
      }
      String customDelimiter = Pattern.quote(userInput.substring(2, delimiterIndex));
      return customDelimiter + "|,|:"; // 커스텀 구분자와 기본 구분자 모두 포함
    }
    return ",|:"; // 기본 구분자만 반환
  }

  // 구분자로 숫자 분리
  private String[] splitNumbers(String userInput, String delimiter) {
    if (userInput.startsWith("//")) {
      int delimiterIndex = userInput.indexOf("\\n");
      if (delimiterIndex == -1) {
        throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
      }
      userInput = userInput.substring(delimiterIndex + 2); // "\\n" 이후의 문자열
    }

    String[] splitNumbers = userInput.split(delimiter);
    return removeInvalidNumbers(splitNumbers);
  }

  // 커스텀 구분자 정의 시 //와 \n 제거
  private String[] removeInvalidNumbers(String[] numbers) {
    return Arrays.stream(numbers)
        .map(String::trim)
        .filter(number -> !number.isEmpty() && !number.equals("//") && !number.equals(
            "\n")) // 빈 문자열과 '//' 제거
        .toArray(String[]::new);
  }
}
