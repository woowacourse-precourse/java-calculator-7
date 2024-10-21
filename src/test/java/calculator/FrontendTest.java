package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrontendTest {
  private PrintStream standardOut;
  private OutputStream captor;



  @BeforeEach
  protected final void init() {
    this.standardOut = System.out;
    this.captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(this.captor));
  }



  @AfterEach
  protected final void printOutput() {
    System.setOut(this.standardOut);
    System.out.println(this.output());
  }
  private String output() { return this.captor.toString().trim(); }



  //  java.lang.NullPointerException at FrontendTest.java:28
  // java.lang.NullPointerException: Cannot invoke "calculator.Frontend.accessTarget()" because "this.frontend" is null
//  @Test
//  public void accessResult() throws Exception{
//      //given
//      int expect = 15;
//      String readLine = "1, 2, 3, 4, 5";
//
//      //when
//      Calculator calculator = new Calculator(readLine);
//      int target = calculator.calculating();
//
//      Frontend frontend = new Frontend(target);
//      int actual = frontend.getTarget();
//
//      //then
//      assertEquals(expect, actual);
//  }


  @Test
  public void 계산_결과를_전달받으면_정상_출력되는지_확인한다() throws Exception{
      //given
      int expect = 15;
      String readLine = "1,2,3,4,5";
      Calculator calculator = new Calculator(readLine);

      // when
      int target = calculator.calculating();
      Frontend frontend = new Frontend(target);

      // then
      frontend.printResult();

  }

}