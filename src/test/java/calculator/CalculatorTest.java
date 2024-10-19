package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
  Calculator calculator;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator("//;\\n1;2;3");
    calculator=calculator.splitOrInsert().matchesRegex();
  }

  @Test
  public void allPositiveNumbersTest() {
    int[] numbers=new int[]{1,2,3};
    assertArrayEquals(new int[]{1,2,3},calculator.allPositiveNumber(numbers).numbers);
  }

  @Test
  public void addTest() {
    int result = calculator.add(new int[]{1, 2, 3});
    assertEquals(6, result);

  }



}

