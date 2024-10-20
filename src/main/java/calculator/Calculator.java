package calculator;

import static java.lang.Character.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Calculator {

  private int target = 0;

  public int calculating(String readLine) {

    // [] 입력 문자열 탐색중
    for (int i = 0; i < readLine.length(); i++) {
      // 문자열이 커스텀 구분자로 시작하면
      if (readLine.startsWith("//;\\n")) {
        // 비정상 입력을 체크하고

        // 정상인 경우 결과를 합산한다
        String numeric = valueOf(readLine.charAt(i));
        addNumbers(convertToNumber(numeric));
      }
      char index = readLine.charAt(i);
      // 예외 체크
      checkException(index);
      // 처리
      validProcess(index);
    }
    // 전달
    return target;
  }
  // 문자열을 숫자로 변환
  private static char convertToNumber(String numeric) {
    return (char) parseInt(numeric);
  }

  private void validProcess(char index) {
    //  인덱스가 기본 구분자 ‘,’ , ‘:’ 인 경우
    if (index == ',' || index == ':') {
      // 건너뛴다
      return;
    }
    addNumbers(index);
  }

  private void addNumbers(char index) {
    // [] 입력 문자열 탐색 중 인덱스가 정수 변환 가능한 경우
    if (isDigit(index)) {
      // target에 합산한다
      target += parseInt(valueOf(index));
    }
  }

  // 문자열의 요소가 유효하지 않으면 예외 처리한다
  private void checkException(char index) {
    // [x] 디버깅 :  오타 수정 && -> !=
    // 특정 구분자가 아닌 경우
    if (index != ',' && index != ':' && isDigit(index)) {
      // [] 비정상 입력 예외 처리
      throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':'");
    }





  }
}
