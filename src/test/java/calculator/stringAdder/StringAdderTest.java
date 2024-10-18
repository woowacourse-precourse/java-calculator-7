package calculator.stringAdder;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 18.
 */
class StringAdderTest extends NsTest {


  @ParameterizedTest
  @CsvSource({
      "1:2:3, 6",
      "10:20:30, 60",
      "5:15:25:35, 80",
      "999:1, 1000"
  })
  @DisplayName("기본 구분자 유효한 입력")
  void run_validInputForDefaultDelimiters_success(String input, String expected) {
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : "+expected);
    });
  }

  @ParameterizedTest
  @CsvSource({
      "//a\\n1a2:3, 6",
      "//$\\n10$20:30, 60",
      "// \\n5:15 25:35, 80",
      "//\t\\n999\t1, 1000",
      "//\b\\n999\b1, 1000"
  })
  @DisplayName("커스텀 구분자 유효한 입력")
  void run_validInputForCustomDelimiters_success(String input, String expected) {
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : "+expected);
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "\n"})
  @DisplayName("빈 문자열 입력")
  void run_emptyInput_throwIllegalArgumentException(String input) {
    assertThatThrownBy(() -> runException(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("InputValidator");
  }

  @ParameterizedTest
  @ValueSource(strings = {"////;\\n\\n1,2,3", "//;;\\n1,2,3", "//\\n"})
  @DisplayName("올바르지 않은 커스텀 구분자 설정")
  void run_invalidCustomDelimiters_throwIllegalArgumentException(String input) {
    assertThatThrownBy(() -> runException(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("DelimiterParser");
  }

  @Test
  @DisplayName("커스텀 구분자에 기본 구분자 설정")
  void run_defaultDelimiterInCustomDelimiterSetting_success() {
    String input = "//:\\n1:2:3";
    String expected = "6";
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : "+expected);
    });
  }




  @Override
  protected void runMain() {
    Application.main(new String[]{});
  }
}