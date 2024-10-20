package calculator;

import static java.lang.Character.*;
import static java.lang.String.valueOf;

public class Calculator {

  private int target = 0;

  public int calculating(String readLine) {

    // [] 입력 문자열 탐색중
    for (int i = 0; i < readLine.length(); i++) {
      char index = readLine.charAt(i);
      // 예외 체크
      checkException(index);
      // 처리
      validProcess(index);
    }
    // 전달
    return target;
  }

  private void validProcess(char index) {
    //  인덱스가 기본 구분자 ‘,’ , ‘:’ 인 경우
    if (index == ',' || index == ':') {
      // 건너뛴다
      return;
    }
    // [] 입력 문자열 탐색 중 인덱스가 정수 변환 가능한 경우
    if (isDigit(index)) {
      // target에 합산한다
      target += Integer.parseInt(valueOf(index));
    }
  }

  // 문자열 유효 체크
  private void checkException(char index) {
    if (index != ',' && index && ':' && !isDigit(index)) {
      // [] 비정상 입력 예외 처리
      throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':'");
    }




  }
}
