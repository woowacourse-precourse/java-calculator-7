package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexCheckTest {
  private Calculator calculator;
  final String SORT="(//([^0-9]+)\\\\n)?([0-9]+|[^0-9]+)+";

  @BeforeEach
  public void setUp() {
    calculator = new Calculator("//`\\n1`2`3");
    calculator.isCorrect(SORT);
    calculator.division();
  }

  @Test
  public void testIsCorrect() {
    assertTrue(calculator.isCorrect(SORT));
  }

  @Test
  public void checkTest() {
    String[] arr=calculator.check();
    System.out.println(Arrays.toString(arr));
  }
}
