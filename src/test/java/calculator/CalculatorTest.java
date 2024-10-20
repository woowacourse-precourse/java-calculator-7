package calculator;

import static java.lang.String.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  Calculator calculator;


  // 이것도 외부 라이브러리 사용인건가??????

  /**
   *
   * @BeforeEach
   *   void setUp() {
   *     calculator = new Calculator();
   *   }
   */


  public static InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }


  @Test
  public void 문자열이_입력되면_구분자와_정수를_분리한다() throws Exception{
    //given
    String input = "1, 2, 3";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Scanner scanner = new Scanner(System.in);
    String readLine = scanner.nextLine();

    // when
    int actual = 0;
    for (int i = 0; i < readLine.length(); i++) {

      char index = readLine.charAt(i);

      // [x] 문자열이 구분자인 경우 건너뛰고
      if (index == ',' || index == ':') {
        continue;
      }
      // [x] 커스텀 구분자가 문자열 맨 앞에 지정된 경우
      // //;\n

      // [x] charArray 인덱스0부터 5까지의 값이 "//;\n" 인지 체크
      boolean validCustomSeparator = readLine.startsWith("//;\\n");
      if (validCustomSeparator) {
        // 맞다면 커스텀 구분자 ';'인지 체크하고 건너뛰거나
        if (index == ';') {
          continue;
        }
        // 정상적인 커스텀 구분자가 아닌 경우 IllegalArgumentException
        throw new IllegalArgumentException("커스텀 구분자를 확인해주세요 ('//;\\n'를 맨 앞에 선언 후 ';' 사용");
      }
      // [x] 탐색 인덱스가 정수 변환 가능한 경우
      if (Character.isDigit(index)) {
        // actual과 합산을 반복
        int target = Integer.parseInt(valueOf(index));
        actual += target;
      }
      // [X] 잘못된 입력값은 예외처리
      boolean validInput = valueOf(index).equals(",") || valueOf(index).equals(":");
      if (!validInput) {
        throw new IllegalArgumentException("입력 가능한 문자열인지 확인해주세요. ',', ':' ");
      }

    }
    int expected = 6;

    // 기대값, 실제값 비교 검증
    //then
    assertEquals(expected, actual);

  }




  public void 입력값이_잘못된_경우_예외_처리한다() throws Exception{
      //given
    // 잘못된 입력값이 들어온 경우 예외처리한다
   char[] invalidInput = new char[]{'.', '/', '>', '!', '?'};
      //when
     String readLine = "배달의 민족 삭제";

      //then
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculating(readLine);
    });
  }


  @Test
  public void 탐색_인덱스가_정수_변환_가능한지_확인한다() throws Exception{
      //given
      char[] isNumeric = new char[]{'1', '2', '3', '4', '5'};


      //when
      boolean expect = true;

      for (char element : isNumeric) {
        boolean actual = Character.isDigit(element);
        assertEquals(expect, actual);

      }


  }


  @Test
  public void 입력값이_유효한_경우를_확인한다() throws Exception{
      //given
      char[] delimeters = new char[]{',', ':', ';'};


      boolean expect = true;
      for (char element : delimeters) {
        //then
        assertEquals(expect, calculator.validProcess(element));
      }
    boolean actualCustom = calculator.readline.subString(0, 5) == custom;
    assertEquals(expect, actualCustom);
  }

}