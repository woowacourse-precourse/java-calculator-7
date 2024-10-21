package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 문자열 덧셈 계산기를 구현하는 클래스입니다.
 */
public class StringAddCalculator {

  /**
   * 프로그램 실행의 시작점입니다.
   */
  public void run() {
    String input = readInput();
    int result = calculate(input);
    System.out.println("결과 : " + result);
  }

  /**
   * 사용자로부터 문자열을 입력받습니다.
   *
   * @return 입력받은 문자열
   */
  private String readInput() {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    return Console.readLine();
  }

  /**
   * 입력된 문자열을 바탕으로 계산을 수행합니다.
   *
   * @param userInput 입력된 문자열
   * @return 계산 결과
   */
  public int calculate(String userInput) {
    String delimiter = getDelimiter(userInput);
    String[] numbers = splitNumbers(userInput, delimiter);
    return sumNumbers(numbers);
  }

  /**
   * 문자열에서 구분자를 추출합니다.
   *
   * @param userInput 입력된 문자열
   * @return 추출된 구분자
   */
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

  /**
   * 구분자로 숫자를 분리합니다.
   *
   * @param userInput 입력된 문자열
   * @param delimiter 구분자
   * @return 분리된 숫자 배열
   */
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

  /**
   * 유효하지 않은 숫자를 제거합니다.
   *
   * @param numbers 숫자 배열
   * @return 유효한 숫자 배열
   */
  private String[] removeInvalidNumbers(String[] numbers) {
    return Arrays.stream(numbers)
        .map(String::trim)
        .filter(number -> !number.isEmpty() && !number.equals("//") && !number.equals(
            "\n")) // 빈 문자열과 '//' 제거
        .toArray(String[]::new);
  }

  /**
   * 추출한 숫자의 합을 계산합니다.
   *
   * @param numbers 숫자 배열
   * @return 합계
   */
  private int sumNumbers(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      try {
        int num = Integer.parseInt(number);
        if (num < 0) {
          throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        sum += num;
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
      }
    }
    return sum;
  }
}