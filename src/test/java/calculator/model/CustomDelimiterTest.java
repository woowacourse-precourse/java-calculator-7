package calculator.model;

import calculator.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("커스텀 구분자 테스트")
class CustomDelimiterTest {

    @Test
    @DisplayName("커스텀 구분자가 3개를 초과하면 예외가 발생한다.")
    void isCustomDelimiterCountExceedLimit() {
        assertThatThrownBy(() -> new CustomDelimiter(";!?#").validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CUSTOM_DELIMITER_LIMIT.getError());
    }

    @Test
    @DisplayName("커스텀 구분자가 3개 이하이면 예외가 발생하지 않는다.")
    void isCustomDelimiterCountBelowLimit() {
        assertThatCode(() -> new CustomDelimiter(";!?").validate())
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-","/","\\","0","9"})
    @DisplayName("커스텀 구분자에 -,/,\\나 숫자를 입력하면 예외가 발생한다.")
    void isCustomDelimiterFormatInvalid(String delimiter) {
        assertThatThrownBy(() -> new CustomDelimiter(delimiter).validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CUSTOM_DELIMITER_FORMAT.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"@","!","a","가","+","=","^"})
    @DisplayName("커스텀 구분자에 -,/,\\나 숫자가 없으면 예외가 발생하지 않는다.")
    void isCustomDelimiterFormatValid(String delimiter) {
        assertThatCode(() -> new CustomDelimiter(delimiter).validate())
                .doesNotThrowAnyException();
    }

}