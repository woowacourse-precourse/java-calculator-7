package calculator;

public class Calculator {


  public int calculating(String readLine) {

    // 문자열이 입력되면 정수를 탐색한다
    for (int i = 0; i < readLine.length(); i++) {
      char index = readLine.charAt(i);
      valid(index);

      Calculator


    }
    return 0;
  }

  // 문자열 유효 체크
  private void valid(char index) {
    // 문자열에 ',', ':', '//;\n', ,'0-9'가 아닌 값이 입력되어 있는 경우
    if (index == ',' || index == ':') {
      continue;
    }

    // 아닌 경우 예외 처리
    throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':'");
  }
}
