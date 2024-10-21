package calculator;

import static java.lang.String.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private PrintStream standardOut;
  private OutputStream captor;

  @BeforeEach
  protected final void init() {
    this.standardOut = System.out;
    this.captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(this.captor));
  }


  public static InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }


  // java.lang.IllegalArgumentException at CalculatorTest.java:45
  @Test
  public void 유효_문자열이_입력되면_계산_결과를_전달한다() throws Exception{
    //given
    String input = "1, 2, 3";
    int expect = 6;
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Scanner scanner = new Scanner(System.in);
    String readLine = scanner.nextLine();

    // when
    Calculator calculator = new Calculator(input);
    int actual = calculator.calculating(input);

    // then
    assertEquals(expect, actual);
  }




  // 통과
  // 메인 테스트 실패
  @Test
  public void 입력값이_잘못된_경우_예외_처리한다() throws Exception{
      //given
    // 잘못된 입력값이 들어온 경우 예외처리한다
      //when
     String deleteBamin = "배달의 민족 삭제";
     String NoMoreWoowa = "우아한 테크코스 탄핵 시위";
     String failConcert = "우아콘 추첨 실패";
    String actual = "-1,2,3";
    Calculator calculator = new Calculator(deleteBamin);
      //then
      assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculating(deleteBamin);
      calculator.calculating(NoMoreWoowa);
      calculator.calculating(failConcert);
      calculator.calculating(actual);
    });
  }


  // 통과
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

  // java.lang.IllegalArgumentException at CalculatorTest.java:108
  @Test
  public void 입력값이_유효한_경우를_확인한다() throws Exception{
      //given
      String customDelimeter = "//;\\n1;2;3";
      String defaultDelimeter = "1,0:5,9";

    // "this.calculator" is null
    // "calculator.Calculator.calculating(String)" because "this.calculator" is null
    Calculator customCalculator = new Calculator(customDelimeter);
    Calculator defaultCalculator = new Calculator(defaultDelimeter);

//    int calculateCustom = customCalculator.calculating(customDelimeter);
    int calculateDefault = defaultCalculator.calculating(defaultDelimeter);

  }

}