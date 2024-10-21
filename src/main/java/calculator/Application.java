package calculator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {


  /**
   * 문자열을 입력 메소드 return 입력받은 문자열
   */
  public String getInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String input = scanner.nextLine();
    return input;
  }

  /**
   * 구분자 세팅 메소드 return 구분자 Set 모음
   */
  public Set<String> separatorCheck(String input) {
    Set<String> separator = new HashSet<>();
    separator.add(",");
    separator.add(":");
    if (input.startsWith("//")) {
      int delimiterIndex = input.indexOf("\\n");
      String customDelimiter = input.substring(2, delimiterIndex);
      separator.add(customDelimiter);
    }
    return separator;
  }

  /**
   * 각 숫자를 합하는 메소드 return 모든 수의 합(sum)
   */
  public int sumAll(String input, Set<String> separator) {
    String delimiterPattern = String.join("|", separator); // Set에 있는 구분자를 패턴으로 생성

    // "//"로 시작하는 경우 입력에서 구분자와 숫자를 분리
    if (input.startsWith("//")) {
      int delimiterIndex = input.indexOf("\\n");
      input = input.substring(delimiterIndex + 2); // 구분자 부분 제거
    }

    // 입력값이 없는 경우 0 반환
    if (input.isEmpty()) {
      throw new IllegalArgumentException("숫자를 입력하지 않으셨습니다.");
    }

    // 구분자를 기준으로 문자열 분리
    String[] numbers = input.split(delimiterPattern);

    // 숫자 합 계산 및 에러 처리 (숫자가 아닌 값이 있을 때)
    int sum = 0;
    for (String number : numbers) {
      try {
        if (Integer.parseInt(number) < 0) {
          throw new IllegalArgumentException("음수를 입력했습니다.");
        }
        sum += Integer.parseInt(number);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("입력된 문자열에 숫자가 아닌 값이 포함되어 있습니다.");
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Application application = new Application();
    String input = application.getInput();
    Set<String> separator = application.separatorCheck(input);
    int result = application.sumAll(input, separator);
    System.out.println("결과 : " + result);
  }
}
