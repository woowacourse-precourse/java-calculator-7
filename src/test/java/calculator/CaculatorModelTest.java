package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.CalculatorModel;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CaculatorModelTest {

  @DisplayName("빈 문자열 또는 공백안 경우")
  @ParameterizedTest
  @ValueSource(strings = {"", "   "})
  void testEmptyOrBlankInput(String input) {
    CalculatorModel calculator = new CalculatorModel();
    int result = calculator.sum(input);
    assertEquals(0, result);
  }


  @DisplayName("기본 구분자를 가지는 문자열인 경우")
  @ParameterizedTest
  @MethodSource("provideBasicSeperatorInputs")
  void testBasicSeperator(String input, int expected) {
    CalculatorModel calculator = new CalculatorModel();
    int result = calculator.sum(input);
    assertEquals(expected, result);
  }

  static Stream<Arguments> provideBasicSeperatorInputs() {
    return Stream.of(
        Arguments.of("1,2", 3),
        Arguments.of("1,2,3", 6),
        Arguments.of("1,2:3", 6)
    );
  }

  @DisplayName("커스텀 구분자를 가지는 문자열인 경우 - 성공")
  @ParameterizedTest
  @MethodSource("provideCustomCustomInputs")
  void testCustomSeperator(String input, int expected) {
    CalculatorModel calculator = new CalculatorModel();
    int result = calculator.sum(input);
    assertEquals(expected, result);
  }

  static Stream<Arguments> provideCustomCustomInputs() {
    return Stream.of(
        Arguments.of("//;\\n1;2;3", 6),
        Arguments.of("//|\\n1|2|3", 6),
        Arguments.of("//#\\n1#2#3", 6)
    );
  }

  @DisplayName("커스텀 구분자를 가지는 문자열인 경우 - 실패")
  @Test
  void testInvalidCustomSeparator() {
    CalculatorModel calculator = new CalculatorModel();
    assertThrows(IllegalArgumentException.class, () -> calculator.sum("//;1;2;3"));
    assertThrows(IllegalArgumentException.class, () -> calculator.sum("//;\\n1;2,3"));
  }

  @DisplayName("숫자가 아닌 문자가 포함된 경우")
  @Test
  void testInvalidNumberFormat() {
    CalculatorModel calculator = new CalculatorModel();
    assertThrows(IllegalArgumentException.class, () -> calculator.sum("//;\n1;a;3"));
  }


}
