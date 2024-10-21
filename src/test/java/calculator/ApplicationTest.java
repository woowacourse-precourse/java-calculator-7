package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final String DOUBLE_OVERFLOW_NUMBER = new BigDecimal(Double.MAX_VALUE) + "00";

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,4", "1.2,8.8"})
    @DisplayName("기본 구분자 사용시 덧셈 결과 출력")
    void useDefaultDelimiter() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//^\\n1^2^3^4", "//#\\n1#2#3#4"})
    @DisplayName("커스텀 구분자 지정시 덧셈 결과 출력")
    void useCustomDelimiter(String expression) {
        assertSimpleTest(() -> {
            run(expression);
            assertThat(output()).contains("결과 : 10");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "//#\\n"})
    @DisplayName("빈 문자열 입력시 결과를 0으로 처리")
    void inputEmptyString(String expression) {
        assertSimpleTest(() -> {
            run(expression);
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("숫자 또는 구분자가 아닌 문자 입력시 에러 처리")
    void inputInvalidCharacter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NON_NUMERIC_CHARACTER.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2", "-1,2,3"})
    @DisplayName("0 또는 음수 입력시 에러 처리")
    void inputNonPositiveNumber(String expression) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(expression))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NON_POSITIVE_NUMBER.getMessage())
        );
    }

    @Test
    @DisplayName("0 또는 음수 입력시 에러 처리")
    void inputDoubleOverFlowNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(DOUBLE_OVERFLOW_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_DOUBLE_OVERFLOW_NUMBER.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//@#!\\n", "//;", "//\\n"})
    @DisplayName("커스텀 구분자 입력 양식을 잘못 입력시 에러 처리")
    void inputInvalidCustomDelimiterFormat(String expression) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(expression))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//.\\n", "//1\\n "})
    @DisplayName("커스텀 구분자로 . 또는 숫자 입력시 에러 처리")
    void inputInvalidCustomDelimiterValue(String expression) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(expression))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CUSTOM_DELIMITER_VALUE.getMessage())
        );
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
