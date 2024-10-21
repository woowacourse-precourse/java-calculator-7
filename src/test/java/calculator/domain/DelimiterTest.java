package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("constructor() : 구분자를 정상적으로 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {";", "-", "/"})
    void constructor_delimiter_success(String symbol) throws Exception {
        //given & when & then
        assertThatCode(() -> new Delimiter(symbol))
                .doesNotThrowAnyException();;
    }

    @DisplayName("validateNotNullOrEmpty() : 구분자가 빈 문자열인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateNotNullOrEmpty_delimiter_fail(String symbol) throws Exception{
        //given
        String errorMessage = "[ERROR] 구분자가 빈 문자열일 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> new Delimiter(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("validateNoDigits() : 구분자에 숫자가 포함된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,", ",2", "33", "3,4"})
    void validateNoDigits_delimiter_fail(String symbol) throws Exception{
        //given
        String errorMessage = "[ERROR] 구분자에 숫자가 포함될 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> new Delimiter(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}