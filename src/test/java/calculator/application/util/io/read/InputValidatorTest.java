package calculator.application.util.io.read;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest(name = "({index}) : {0} ==> {1}")
    @CsvSource(
            value = {"1&2&3 ", "//;\\n1;2;3", "1,2,3"},
            delimiter = ':'
    )
    void 정상_값_입력시_정상_결과_반환(
            // given
            String given
    ) {
        // when & then
        assertThatCode(() -> InputValidator.validateNullAndEmpty(given))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "({index}) : '{arguments}' ==> IllegalArgumentException")
    @ValueSource(strings = { " ", "   ", "\n" })
    void 빈_값_입력시_IllegalArgumentException_반환(
            // given
            String given
    ) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateNullAndEmpty(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

}