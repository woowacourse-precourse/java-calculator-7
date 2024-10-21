package calculator.model;

import calculator.Model.CustomInput;
import calculator.global.exception.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomInputTest {

    @DisplayName("음수값 입력시 예외발생")
    @Test
    void testNegativeNumberException() {
        // given
        String inputWithNegative = "//;\\n1,-2;3";

        // when
        Executable executable = () -> new CustomInput(inputWithNegative);

        // then
        IllegalStateException exception = assertThrows(IllegalStateException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.POSITIVE_NUMBER_REQUIRED_ERROR.getValue());
    }

    @DisplayName("숫자가 아닌 값이 들어갔을 때")
    @Test
    void testNonNumericInputException() {
        // given
        String inputWithNonNumeric = "//;\\n1,m;3";

        // when
        Executable executable = () -> new CustomInput(inputWithNonNumeric);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.NON_NUMERIC_INPUT_ERROR.getValue());
    }

    @DisplayName("잘못된 구분자 사용시 예외 발생")
    @Test
    void testInvalidDelimiterException() {
        // given
        String inputWithInvalidDelimiter = "//;\\n1,m]3";

        // when
        Executable executable = () -> new CustomInput(inputWithInvalidDelimiter);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.NON_NUMERIC_INPUT_ERROR.getValue());
    }

    @ParameterizedTest
    @DisplayName("\\n이 없거나 다른 문자가 사용된 경우")
    @ValueSource(strings = {"//;\\q1;2;3", "//;1;2;3"})
    void testFormatDelimiterException(String userInput) {
        // given
        System.setIn(readUserInput(userInput));

        // when
        Executable executable = () -> new CustomInput(userInput);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.CUSTOM_DELIMITER_FORMAT_ERROR.getValue());
    }

    @DisplayName("커스텀 구분자의 값이 숫자인 경우")
    @Test
    void testFormatDelimiterNuberException() {
        // given
        String inputWithInvalidDelimiter = "//1\\n112:2";

        // when
        Executable executable = () -> new CustomInput(inputWithInvalidDelimiter);

        // then
        IllegalStateException exception = assertThrows(IllegalStateException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.INVALID_DELIMITER_ERROR.getValue());
    }


    public InputStream readUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}
