package calculator.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.constant.ExceptionConstant.CUSTOM_DELIMITER_EXCEPTION;
import static calculator.constant.ExceptionConstant.NUMBER_NOT_POSITIVE_EXCEPTION;
import static calculator.utils.ValidatorUtils.validateCustomDelimiter;
import static calculator.utils.ValidatorUtils.validateNumbers;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorUtilsTest {

    @Test
    @DisplayName("음수 validator Test")
    void 음수_VALIDATOR_TEST(){
        List<Double> numbers = new ArrayList<>(Arrays.asList(-1.0, 1.0, 2.0));
        Assertions.assertThatThrownBy(() -> validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_NOT_POSITIVE_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[]", "3"})
    @DisplayName("커스텀 구분자 EXCEPTION TEST")
    void CUSTOM_DELIMITER_EXCEPTION_TEST(final String customDelimiter){
        Assertions.assertThatThrownBy(() -> validateCustomDelimiter(customDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CUSTOM_DELIMITER_EXCEPTION);
    }

}