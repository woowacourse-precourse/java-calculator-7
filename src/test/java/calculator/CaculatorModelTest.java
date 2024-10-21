package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.CaculatorModel;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CaculatorModelTest {

  @DisplayName("빈 문자열 또는 공백안 경우")
  @ParameterizedTest
  @ValueSource(strings = {"", "   "})
  void testEmptyOrBlankInput(String input) {
    CaculatorModel caculator = new CaculatorModel(input);
    int result = caculator.sum();
    assertEquals(0, result);
  }


  @DisplayName("기본 구분자를 가지는 문자열인 경우")
  @ParameterizedTest
  @MethodSource("provideBasicSeperatorInputs")
  void testBasicSeperator(String input, int expected) {
    CaculatorModel caculator = new CaculatorModel(input);
    int result = caculator.sum();
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
    CaculatorModel caculator = new CaculatorModel(input);
    int result = caculator.sum();
    assertEquals(expected, result);
  }

  static Stream<Arguments> provideCustomCustomInputs() {
    return Stream.of(
        Arguments.of("//;\n1;2;3", 6),
        Arguments.of("//|\n1|2|3", 6),
        Arguments.of("//#\n1#2#3", 6)
    );
  }

  @DisplayName("커스텀 구분자를 가지는 문자열인 경우 - 실패")
  @Test
  void testInvalidCustomSeperator() {
    CaculatorModel caculator1 = new CaculatorModel("//;1;2;3");
    assertThrows(IllegalArgumentException.class, caculator1::sum);

    CaculatorModel caculator2 = new CaculatorModel("//;\n1;2,3");
    assertThrows(IllegalArgumentException.class, caculator2::sum);
  }

  @DisplayName("숫자가 아닌 문자가 포함된 경우")
  @Test
  void testInvalidNumberFormat() {
    CaculatorModel caculator = new CaculatorModel("//;\n1;a;3");
    assertThrows(IllegalArgumentException.class, caculator::sum);
  }


}
