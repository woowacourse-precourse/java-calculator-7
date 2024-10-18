package calculator.stringAdder;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
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
  @ValueSource(strings = {"1","2","3"})
  @DisplayName("단일 숫자")
  void run_singleNumber_success(String input) {
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : "+input);
    });
  }

  @Test
  @DisplayName("양수가 아닌 0 예외처리")
  void run_zeroNumber_success() {
    assertThatThrownBy(() -> runException("0"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("NumberParser");
  }

  @Test
  @DisplayName("매우 큰 숫자")
  void run_exceedLongRange_success() {
    String input = "//;\\n"+"9999999999999999999999999,1,100000000077777777777777;1";
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : 10100000000077777777777778");
    });
  }

  @ParameterizedTest
  @CsvSource({
      "1:2, 3",
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

  @Test
  @DisplayName("기본 구분자 쉼표 유효한 입력")
  void run_validInputForDefaultDelimitersPeriod_success() {
    String input = "1,2,3";
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : 6");
    });
  }

  @Test
  @DisplayName("기본 구분자 혼합 유효한 입력")
  void run_validInputForDefaultDelimitersMixed_success() {
    String input = "1:2,3";
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : 6");
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
  void run_emptyInput_returnResult(String input) {
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : 0");
    });
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

  @Test
  @DisplayName("음수 입력")
  void run_negativeNumber_throwIllegalArgumentException(){
    String input = String.valueOf(Long.MAX_VALUE)+",-1,2,3";
    assertThatThrownBy(() -> runException(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("NumberParser");
  }

  @Test
  @DisplayName("소수 입력")
  void run_decimalNumber_throwIllegalArgumentException(){
    String input = String.valueOf(Long.MAX_VALUE)+",0.5,2,3";
    assertThatThrownBy(() -> runException(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("NumberParser");
  }

  @Test
  @DisplayName("특수 문자")
  void run_specialDelimiter_throwIllegalArgumentException(){
    assertThatThrownBy(() -> runException("\t"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("NumberParser");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1a,2,3", "1,2b,3", "1,2,3c"})
  @DisplayName("유효하지 않은 숫자 형식")
  void run_invalidNumberFormat_fail(String input) {
    assertThatThrownBy(() -> runException(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("NumberParser");;
  }


  @Override
  protected void runMain() {
    Application.main(new String[]{});
  }
}