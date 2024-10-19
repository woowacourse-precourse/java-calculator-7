package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringAddCalculator {

  public static void main(String[] args) {
    // 사용자 입력 받기
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String userInput = Console.readLine();
  }

  // 커스텀 구분자 형식 유효성 검사
  private static void validateInput(String userInput) throws IllegalAccessException {
    if (userInput.startsWith("//")) {
      int delimiterIndex = userInput.indexOf('\n');
      String numbersPart = userInput.substring(delimiterIndex + 1);
      if (numbersPart.isEmpty()) {
        throw new IllegalAccessException("잘못된 구분자 형식입니다.");
      }
    }
  }
}
