package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrontendTest {

  Frontend frontend;

  @BeforeEach
  void setUp()  {
    frontend = new Frontend();
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

}