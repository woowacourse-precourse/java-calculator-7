package calculator.stringAdder.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 18.
 */
class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp(){
    calculator = new Calculator();
  }

  @Test
  void sum_emptyArray_success(){
    String[] numbers = {};
    assertEquals("0", calculator.sum(numbers));
  }

  @Test
  void sum_singleNumber_success(){
    String[] numbers = {"23"};
    assertEquals(numbers[0], calculator.sum(numbers));
  }

  @ParameterizedTest
  @CsvSource({
      "1;2;3, 6",
      "10;20;30, 60",
      "5;15;25;35, 80",
      "999;1, 1000"
  })
  void sum_validNumbers_success(String input, String expected) {
    String[] numbers = input.split(";");
    assertEquals(expected, calculator.sum(numbers));
  }

  @Test
  void sum_largeNumbers_success() {
    String[] numbers = {"999999223372036854775807999922337203685477580", "1"};
    assertEquals("999999223372036854775807999922337203685477581", calculator.sum(numbers));
  }

  @Test
  void sum_manyNumbers_success() {
    String[] numbers = new String[99999999];
    Arrays.fill(numbers, "1");
    assertEquals(String.valueOf(numbers.length), calculator.sum(numbers));
  }

  @Test
  void sum_mixOfSmallAndLargeNumbers_returnsCorrectSum() {
    String[] numbers = {"9999999999999999999999999", "1", "100000000077777777777777", "1"};
    assertEquals("10100000000077777777777778", calculator.sum(numbers));
  }
}