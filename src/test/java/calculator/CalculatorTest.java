package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  public static InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }


  @Test
  @DisplayName("문자열이 입력되면 구분자와 정수를 분리한다")
  public void separateInteger() throws Exception{
    //given
    String input = "1, 2, 3";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Scanner scanner = new Scanner(System.in);
    String string = scanner.nextLine();

    // when
    int actual = 0;
    for (int i = 0; i < string.length(); i++) {

      char index = string.charAt(i);

      // 문자열이 구분자인 경우 건너뛰고
      if (index == ',' || index == ':') {
        continue;
      }
      // 커스텀 구분자가 문자열 맨 앞에 지정된 경우
      // //;\n

      // charArray 인덱스0부터 5까지의 값이 "//;\n" 인지 체크
      // 여기를 어떻게 구현하지..흠 🤔🤔
      boolean validCustomSeparator = string.substring(0, 5) == "//;\\n";
      if (validCustomSeparator) {
        // 맞다면 커스텀 구분자 ';'인지 체크하고 건너뛰거나
        if (index == ';') {
          continue;
        }
        // 정상적인 커스텀 구분자가 아닌 경우 IllegalArgumentException
        throw new IllegalArgumentException("커스텀 구분자를 확인해주세요");
      }
      // 탐색 인덱스가 정수 변환 가능한 경우
      if (Character.isDigit(index)) {
        // actual과 합산을 반복
        int target = Integer.parseInt(String.valueOf(index));
        actual += target;
      }
      // 잘못된 입력값은 예외처리
      throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':', ';' ");

    }
    int expected = 6;

    // 기대값, 실제값 비교 검증
    //then
    assertEquals(expected, actual);

  }

}