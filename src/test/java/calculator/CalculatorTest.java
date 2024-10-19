package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest extends RegexCheckTest {


  @Test
  public void allPositiveNumbers() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculator = new Calculator("//`\\n-1`2`3");
      calculator.matchesAndInsert();
      calculator.allPositiveNumber();
    });
  }


  @Test
  public void addTest() {
    int result = calculator.add(new int[]{1, 2, 3});
    assertEquals(6, result);

  }

}

