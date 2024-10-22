package calculator;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

// google java style guide 도입

/**
 * [x] 공백과 주석 정리
 * [x] 불필요한 import 삭제
 * [x] 가독성 향상을 위한 변수명 개선
 * [x] 조건문 가독성 향상
 */

public class Calculator {

  private String readLine;
  private int target;
  private static final char COMMA = ',';
  private static final char COLON = ':';
  private static final char SEMI_COLON = ';';
  private static final char SLASH = '/';
  private static final char BACK_SLASH = '\\';
  private static final char LINE_BREAK = 'n';
  private static final char BLANK = 'n';
  private static final String REGEX = "[0-9]" ;

  public Calculator(String readLine) {
    this.target = 0;
    this.readLine = readLine;
  }

  public int calculating() {
    boolean isCustomerDelimiter = readLine.startsWith("//;\\n");

    // 입력 문자열 탐색중
    for (int i = 0; i < readLine.length(); i++) {

      // 커스텀 구분자로 시작하면
      if (isCustomerDelimiter) {
        char index = readLine.charAt(i);

        // 유효한 경우엔 건너뛰고
        if (index == SLASH || index == BACK_SLASH || index == SEMI_COLON || index == LINE_BREAK) {
          continue;
        }

        if (index != SLASH && index != BACK_SLASH && !validIsDigit(index) && index != LINE_BREAK) {
          // 커스텀 구분자 또는 정수가 아닌 경우는 예외 처리한다
          throw new IllegalArgumentException(
              "커스텀 구분자를 입력하려면 문자열 맨앞에 '//;\\n'를 붙인 다음 사용해주세요 (예시 //;\\n1;2;3)");
        }

        if (isDigit(index)) {
          // 정수는 target에 합산한다
          addNumbers(readLine.charAt(i));
          break;
        }
      }

      //  인덱스가 기본 구분자 ‘,’ , ‘:’ 인 경우
      if (readLine.charAt(i) == COMMA || readLine.charAt(i) == COLON) {
        // 다음 인덱스 탐색으로 넘어간다
        continue;
      }
      // 예외 체크
      checkException(readLine.charAt(i));
      if (readLine.charAt(i) != COMMA && readLine.charAt(i) != COLON && !validIsDigit(readLine.charAt(i)) && readLine.charAt(i) != BLANK) {
        // 비정상 입력 예외 처리
        throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':' 를 포함한 0-9의 정수 (예시 : 1, 2, 3 또는 1,2:3)");
      }
      // 인덱스가 정수면 합산한다
      if (isDigit(readLine.charAt(i))) {
        addNumbers(readLine.charAt(i));
      }
    }

      // 전달
      return target;
    }

private void addNumbers(char index) {
    // 입력 문자열 탐색 중 인덱스가 정수 변환 가능한 경우
    if (isDigit(index)) {
      // target에 합산한다
      target += parseInt(valueOf(index));
    }
  }

  // 문자열의 요소가 유효하지 않으면 예외 처리한다
  private void checkException(char index) {

    if (index != ',' && index != ':' && !validIsDigit(index)) {
      // [x] 비정상 입력 예외 처리
      throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':' 를 포함한 0-9의 정수 (예시 : 1, 2, 3 또는 1,2:3)");
    }
  }

  private static boolean validIsDigit(char index) {
    boolean validDigit = Character.toString(index).matches(REGEX);
    return validDigit;
  }
}

