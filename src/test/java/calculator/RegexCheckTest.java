package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexCheckTest {
  private Calculator calculator;
//  final String SORT="(//([^0-9]+)\\\\n)?([0-9]+|[^0-9]+)+";
//  final String SORT="(//([^0-9]+)\\\\n)?([0-9][^0-9]+[0-9][^0-9]+[0-9]+)";

  final String SORT = "(//([^0-9])\\\\n)?(([0-9]+[^0-9]+)*[0-9]*)$";

  @BeforeEach
  public void setUp() {
    calculator = new Calculator("1`2`3");
    calculator.isValidByRegex(SORT);
//
  }

  @Test
  public void   isValidInputTest() {
    assertTrue(calculator.isValidByRegex(SORT));
  }

  @Test
  public void matchesRegexTest() {

    assertThrows(IllegalArgumentException.class, () -> {
      calculator = calculator.splitOrInsert().matchesRegex();
      throw new IllegalArgumentException("구분자 확인");
    });
  }
}
