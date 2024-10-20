package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
  Calculator calculator = new Calculator("//`\\n1`2`3");

  @BeforeEach
  public void setUp() {
    calculator.inputValidator();
  }

  @Test
  public void allPositiveNumbers() {
    assertInstanceOf(Calculator.class, calculator.allPositiveNumber());

    assertArrayEquals(new int[]{1,2,3},calculator.allPositiveNumber().getNumbers());

    assertThrows(IllegalArgumentException.class, () -> {
      calculator = new Calculator("//`\\n-1`2`3");
      calculator.inputValidator();
      calculator.allPositiveNumber();
    });

  }


  @Test
  public void addTest() {
    assertEquals(6, Calculator.add(new int[]{1, 2, 3}));
  }

}

