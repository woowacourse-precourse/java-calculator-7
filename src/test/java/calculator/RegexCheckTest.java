package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexCheckTest {
  private Calculator input;

  @BeforeEach
  public void setUp(){
    input=new Calculator("//;\\n1;2;3");

  }

  @Test
  public void testIsSort(){
    assertTrue(input.isSort());
  }

  @Test
  public void testSortCheck() {

  }
}
