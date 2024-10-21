package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrontendTest {



  //  java.lang.NullPointerException at FrontendTest.java:28
  // java.lang.NullPointerException: Cannot invoke "calculator.Frontend.accessTarget()" because "this.frontend" is null
  @DisplayName("계산된 결과에 접근해서 값을 가져온다")
  @Test
  public void accessResult() throws Exception{
      //given
      int expect = 21;
      String target = "1, 2, 3, 4, 5";

      //when
    Calculator calculator = new Calculator();
    calculator.calculating(target);
    // "calculator.Frontend.accessTarget()" because "this.frontend" is null
    Frontend frontend = new Frontend();
      int actual = frontend.accessTarget();

    //then
      assertEquals(expect, actual);
  }

//  @DisplayName("조회된 계산결과를 출력한다")
//  @Test
//  public void testPrintResult() throws Exception{
//      //given
//      int given = 10;
//
//      //when
//      String expect = "결과 : 10";
//      frontend.printResult();
//
//      //then
//      assertEquals();
//
//  }

}