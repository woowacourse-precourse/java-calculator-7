package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrontendTest {

  private Frontend frontend;
  private PrintStream printStream = System.out;

  @BeforeEach
  void setUp()  {
    frontend = new Frontend();
  }

  @AfterEach
  void tearDown() {
    System.setOut(System.out);
  }

  @DisplayName("계산된 결과에 접근해서 값을 가져온다")
  @Test
  public void accessResult() throws Exception{
      //given
      int expect = 10;

      //when
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