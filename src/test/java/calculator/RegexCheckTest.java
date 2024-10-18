package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexCheckTest {
  private Calculator calculator;
  protected String sort = ",:";
  protected String regex = "^[" + sort + "]?[1-9][0-9]*([" + sort + "][1-9][0-9]*)*$";
//  private static final String SORT = "//\\\\[(\\D+)\\\\]\\\\n(.+)";
  private String strNumber;
  private String strSort;
  protected String input;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator("//;\\n1;2;3");
  }

  @Test
  public void testIsSort() {
    assertTrue(calculator.isSort());
  }

  @Test
  public void testDivision() {
    calculator.division("//;\\n1;2;3");
  }
}
