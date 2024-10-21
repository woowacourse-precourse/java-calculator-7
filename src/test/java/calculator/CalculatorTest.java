package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.ErrorMessages;
import calculator.model.Calculator;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testValidInputWithDefaultDelimiters() {
        // 기본 구분자(쉼표, 콜론)를 사용하여 유효한 입력에 대한 테스트
        assertEquals(3, calculator.calculate("1,2"));
        assertEquals(6, calculator.calculate("1,2,3"));
        assertEquals(6, calculator.calculate("1:2:3"));
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    void testValidInputWithCustomDelimiter() {
        // 커스텀 구분자를 사용한 유효한 입력에 대한 테스트
        assertEquals(6, calculator.calculate("//&\\n1&2&3"));
    }

    @Test
    void testInvalidInputWithInvalidCustomDelimiter() {
        // 커스텀 구분자에 숫자가 오는 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//1\\n");
        });
        assertEquals(ErrorMessages.INVALID_CUSTOM_DELIMITER, thrown.getMessage());

        // 커스텀 구분자에 공백이 오는 경우
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("// \\n");
        });
        assertEquals(ErrorMessages.INVALID_CUSTOM_DELIMITER, thrown.getMessage());

        // 커스텀 구분자가 없는 경우
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//\\n");
        });
        assertEquals(ErrorMessages.INVALID_CUSTOM_DELIMITER, thrown.getMessage());
    }

    @Test
    void testInvalidInputWithSameAsDefaultDelimiter() {
        // 기본 구분자인 ":" 과 ","를 커스텀 구분자로 사용하는 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//:\\n1:2:3");
        });
        assertEquals(ErrorMessages.SAME_AS_DEFAULT_DELIMITER, thrown.getMessage());
    }

    @Test
    void testInvalidInputWithMultiCharDelimiter() {
        // 두 글자 이상의 커스텀 구분자를 사용하는 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//@@\\n");
        });
        assertEquals(ErrorMessages.MULTI_CHAR_DELIMITER, thrown.getMessage());

        // 두 글자 이상의 커스텀 구분자를 사용하는 경우 (뒤에 숫자가 있음)
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//;;\\n1");
        });
        assertEquals(ErrorMessages.MULTI_CHAR_DELIMITER, thrown.getMessage());
    }

    @Test
    void testInvalidInputWithMultipleDelimiters() {
        // 두 개 이상의 구분자가 연속으로 입력된 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1,,2");
        });
        assertEquals(ErrorMessages.MULTIPLE_DELIMITERS, thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1::2");
        });
        assertEquals(ErrorMessages.MULTIPLE_DELIMITERS, thrown.getMessage());
    }

    @Test
    void testInvalidInputWithUnknownDelimiter() {
        // 기본 구분자와 커스텀 구분자 외의 지정하지 않은 구분자를 사용하는 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//;\\n1@2@3");
        });
        assertEquals(ErrorMessages.INVALID_CHARACTER, thrown.getMessage());
    }

    @Test
    void testInvalidInputWithEmptyNumberAfterCustomDelimiter() {
        // 커스텀 구분자만 지정하고 숫자를 입력하지 않은 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//;\\n");
        });
        assertEquals(ErrorMessages.EMPTY_NUMBER_AFTER_CUSTOM_DELIMITER, thrown.getMessage());
    }

    @Test
    void testInvalidInputWithInvalidCustomDelimiterFormat() {
        // 커스텀 구분자를 잘못된 형식으로 지정한 경우
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("//;/n");
        });
        assertEquals(ErrorMessages.INVALID_CUSTOM_DELIMITER_FORMAT, thrown.getMessage());
    }
}