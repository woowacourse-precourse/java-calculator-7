package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegexCheckTest {
  Calculator calculator = new Calculator("//`\\n1`2`3");


  @Test
  public void   isValidInputTest() {
    assertTrue(calculator.inputValidator());
  }

  @Test
  public void matchDelimiterTest() {
    assertThrows(IllegalArgumentException.class, () -> {
      Calculator calculator1 = new Calculator("//`\\n1:2`3");
      calculator1.matchesAndInsert();
      throw new IllegalArgumentException("구분자가 잘못되었습니다.");
    });
    calculator.matchesAndInsert();
    assertArrayEquals(new String[]{"1","2","3"},calculator.getStringNumbers());
  }

  @Test
  public void matchNumberTest() {

  }

  @Test
  public void parseIntTest() {
    assertArrayEquals(new int[]{1, 2, 3}, calculator.allPositiveNumber().getNumbers());
  }
}
