package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    calculator.isValidInput(SORT);
//
  }

  @Test
  public void testIsCorrect() {
    assertTrue(calculator.isValidInput(SORT));
  }

  @Test
  public void checkTest() {

    assertThrows(IllegalArgumentException.class, () -> {
      calculator = calculator.splitValues().matchesRegex();
      throw new IllegalArgumentException("Invalid argument");
    });
  }
}
