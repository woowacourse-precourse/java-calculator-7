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
      // 커스텀 구분자를 문자열 맨 앞에 지정한 경우
      if (string.toCharArray().) {
        // 커스텀 구분자 건너뜀
        if (index == ';') {
          continue;
        }
      }
      // 인덱스가 정수 변환 가능한 경우
      if (Character.isDigit(index)) {
        // actual 합산 반복
        int target = Integer.parseInt(String.valueOf(index));
        actual += target;

      }

    }
    int expected = 6;

    // 기대값, 실제값 비교 검증
    //then
    assertEquals(expected, actual);

  }

}