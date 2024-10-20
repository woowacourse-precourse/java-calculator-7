package calculator.domain.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorParserValidatorTest {

    @Test
    @DisplayName("정상 입력: 정수 1")
    void testValidInteger() {
        String input = "1";
        int expectedNumber = 1;
        int number = CalculatorParserValidator.parseToInt(input);
        Assertions.assertEquals(number, expectedNumber);
    }

    @Test
    @DisplayName("예외 테스트: 정수가 아닌 입력 - /1")
    void testInvalidInputWithSlash() {
        String input = "/1";
        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParserValidator.parseToInt(input)
        );
    }

    @Test
    @DisplayName("예외 테스트: 공백 포함된 입력 - {공백}1")
    void testInvalidInputWithLeadingSpace() {
        String input = " 1";
        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParserValidator.parseToInt(input)
        );
    }

    @Test
    @DisplayName("예외 테스트: 정수형 범위를 벗어난 입력 - 2147483648")
    void testInputOutOfIntegerRange() {
        String input = "2147483648";
        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParserValidator.parseToInt(input)
        );
    }

    @Test
    @DisplayName("예외 테스트: 양수가 아닌 입력 - -1")
    void testInputNegativeNumber() {
        String input = "-1";
        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParserValidator.parseToInt(input)
        );
    }

    @Test
    @DisplayName("예외 테스트: 양수가 아닌 입력 - 0")
    void testInputZero() {
        String input = "0";
        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParserValidator.parseToInt(input)
        );
    }
}
