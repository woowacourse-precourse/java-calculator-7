package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegexCheckTest {
  Calculator calculator = new Calculator("//`\\n1`2`3");


  @BeforeEach
  public void setUp() {
    calculator.matchesAndInsert();
  }

  @Test
  public void isValidInputTest() {
    assertTrue(calculator.inputValidator());
  }

  @Test
  public void matchDelimiterTest() {
    Calculator calculator1 = new Calculator("1;2;3");
    assertThrows(IllegalArgumentException.class, calculator1::matchesAndInsert);
  }

  @Test
  public void matchAndInsertTest() {
    assertArrayEquals(new String[]{"1", "2", "3"}, calculator.getStringNumbers());
  }

  @Test
  public void parseIntTest() {
    assertArrayEquals(new int[]{1, 2, 3}, calculator.allPositiveNumber().getNumbers());
  }
}
