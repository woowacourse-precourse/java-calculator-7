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
      int expect = 15;
      String readLine = "1, 2, 3, 4, 5";

      //when
    Calculator calculator = new Calculator(readLine);
    int target = calculator.calculating();

    Frontend frontend = new Frontend(target);
    int actual = frontend.getTarget();

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