package calculator.model;

import calculator.Model.GenernalInput;
import calculator.global.exception.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GenernalInputTest {
    private GenernalInput genernalInput;


    @DisplayName("음수값 입력시 예외발생")
    @Test
    void testNegativeNumberException() {
        // given
        String inputWithNegative = "1,-2,3";

        // when
        Executable executable = () -> new GenernalInput(inputWithNegative);

        // then
        IllegalStateException exception = assertThrows(IllegalStateException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.POSITIVE_NUMBER_REQUIRED_ERROR.getValue());
    }

    @DisplayName("숫자가 아닌 값이 들어갔을 때")
    @Test
    void testNonNumericInputException() {
        // given
        String inputWithNonNumeric = "1,2,a";

        // when
        Executable executable = () -> new GenernalInput(inputWithNonNumeric);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.NON_NUMERIC_INPUT_ERROR.getValue());
    }

    @DisplayName("잘못된 구분자 사용시 예외 발생")
    @Test
    void testInvalidDelimiterException() {
        // given
        String inputWithInvalidDelimiter = "1,2;3";  // 잘못된 구분자 ';' 사용

        // when
        Executable executable = () -> new GenernalInput(inputWithInvalidDelimiter);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertThat(exception.getMessage()).isEqualTo(Exception.NON_NUMERIC_INPUT_ERROR.getValue());
    }

}
