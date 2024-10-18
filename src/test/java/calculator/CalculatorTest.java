package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
  Calculator calculator;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator("//;\\n1;2;3");
  }

  @Test
  public void addTest() {
    int result = calculator.add(new int[]{1, 2, 3});
    assertEquals(6, result);

  }



}

