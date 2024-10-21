package calculator.util;

import org.junit.jupiter.api.Test;

import static calculator.util.Validator.validateNumber;
import static org.junit.jupiter.api.Assertions.*;
import static calculator.common.ErrorMessage.*;

public class ValidatorTest {

    @Test
    public void 숫자_검증_양수일_경우() {
        //given
        String validNumber = "5";

        //when & then
        assertDoesNotThrow(() -> validateNumber(validNumber));
    }

    @Test
    public void 숫자_검증_음수일_경우() {
        //given
        String negativeNumber = "-10";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateNumber(negativeNumber);
        });

        //then
        assertEquals(NEGATIVE_NUMBER_ERROR_MESSAGE + -10, exception.getMessage());
    }

    @Test
    public void 숫자_검증_잘못된_형식일_경우() {
        //given
        String invalidFormat = "abc";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateNumber(invalidFormat);
        });

        //then
        assertEquals(INVALID_NUMBER_FORMAT_ERROR_MESSAGE + invalidFormat, exception.getMessage());
    }

    @Test
    public void 커스텀_구분자_형식_검증_정상_형식() {
        //given
        String validCustomDelimiterInput = "//;\\n1;2;3";

        //when & then
        assertDoesNotThrow(() -> Validator.validateCustomDelimiterFormat(validCustomDelimiterInput));
    }

    @Test
    public void 커스텀_구분자_형식_검증_잘못된_형식() {
        //given
        String invalidCustomDelimiterInput = "//;1;2;3";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCustomDelimiterFormat(invalidCustomDelimiterInput);
        });

        //then
        assertEquals(INVALID_CUSTOM_DELIMITER_FORMAT_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 커스텀_구분자_검증_숫자가_아닌_경우() {
        //given
        String validCustomDelimiter = ";";

        //when & then
        assertDoesNotThrow(() -> Validator.validateCustomDelimiterIsNotNumber(validCustomDelimiter));
    }

    @Test
    public void 커스텀_구분자_검증_숫자인_경우() {
        //given
        String invalidCustomDelimiter = "1";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCustomDelimiterIsNotNumber(invalidCustomDelimiter);
        });

        //then
        assertEquals(CUSTOM_DELIMITER_CANNOT_BE_NUMBER_ERROR_MESSAGE, exception.getMessage());
    }
}