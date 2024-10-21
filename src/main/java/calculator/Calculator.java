package calculator;

import static java.lang.Character.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Calculator {

  private String readLine;
  private int target;

  public Calculator(String readLine) {
    this.target = 0;
    this.readLine = readLine;
  }

  public int calculating() {

    // [] 입력 문자열 탐색중
    for (int i = 0; i < readLine.length(); i++) {

      // 문자열이 커스텀 구분자로 시작하면
      if (readLine.startsWith("//;\\n")) {
        char index = readLine.charAt(i);


        // 커스텀 구분자는 건너뛰고
        if (index == '/' || index == '\\' || index == ';' || index == 'n') {
          continue;
        }
        // 정수는 target에 합산한다
        addNumbers(readLine.charAt(i));

        if (index != '/' && index != '\\' && !validIsDigit(index) && index != 'n') {
          // 커스텀 구분자 또는 정수가 아닌 경우는 예외 처리한다
          throw new IllegalArgumentException(
              "커스텀 구분자를 입력하려면 문자열 맨앞에 '//;\\n'를 붙인 다음 사용해주세요 (예시 //;\\n1;2;3)");
        }

      }


      //  인덱스가 기본 구분자 ‘,’ , ‘:’ 인 경우
      if (readLine.charAt(i) == ',' || readLine.charAt(i) == ':') {
        // 다음 인덱스 탐색으로 넘어간다
        continue;
        }
        // 예외 체크
        checkException(readLine.charAt(i));
        // 처리 : 정수 요소의 덧셈 결과를 합산한다
        addNumbers(readLine.charAt(i));
      }
      // 전달
      return target;
    }


  private void addNumbers(char index) {
    // [X] 입력 문자열 탐색 중 인덱스가 정수 변환 가능한 경우
    if (isDigit(index)) {
      // target에 합산한다
      target += parseInt(valueOf(index));
    }
  }

  // 문자열의 요소가 유효하지 않으면 예외 처리한다
  // 유효한 경우 : 기본 구분자
  private void checkException(char index) {

    if (index != ',' && index != ':' && !validIsDigit(index) && index != ' ') {
      // [x] 비정상 입력 예외 처리
      throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':' 를 포함한 0-9의 정수 (예시 : 1, 2, 3 또는 1,2:3)");
    }
  }

  private static boolean validIsDigit(char index) {
    boolean validDigit = Character.toString(index).matches("[0-9]");
    return validDigit;
  }
}

