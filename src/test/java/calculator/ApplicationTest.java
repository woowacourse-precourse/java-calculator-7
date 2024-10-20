package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    // 성공 케이스
    @Test
    void testSingleNumber() {
        assertEquals("결과 : 1", StringCalculator.calculate("1"));
    }

    @Test
    void testMultipleNumbersWithDefaultDelimiters() {
        assertEquals("결과 : 6", StringCalculator.calculate("1,2:3"));
    }

    @Test
    void testMultipleNumbersWithComma() {
        assertEquals("결과 : 6", StringCalculator.calculate("1,2,3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals("결과 : 1", StringCalculator.calculate("//;\n1"));
    }

    @Test
    void testMixedDelimitersWithCustom() {
        assertEquals("결과 : 10", StringCalculator.calculate("//;\n1;2,3:4"));
    }


    @Test
    void testCustomDelimiterWithMultipleNumbers() {
        assertEquals("결과 : 15", StringCalculator.calculate("//;\n1;2;3;4;5"));
    }

    @Test
    void testSequentialDelimiters() {
        assertEquals("결과 : 5", StringCalculator.calculate("2,::3"));
    }

    // 실패 케이스
    @Test
    void testInvalidCustomDelimiterFormat() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\n1;2;3:"));
    }

    @Test
    void testMissingCustomDelimiter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate(";\\n1"));
    }

    @Test
    void testNegativeNumbers() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("-1,2,3"));
    }

    @Test
    void testNonNumericInput() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("a"));
    }

    @Test
    void testMixedAlphaNumericInput() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("a,1"));
    }

    @Test
    void testCustomDelimiterWithAlphaCharacters() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\\n1;2,3:a"));
    }

    @Test
    void testCustomDelimiterWithNonNumericCharacters() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\\n1;2;ㅁ;4;5"));
    }

    @Test
    void testUnknownDelimiter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\\n1;2,3:4?5"));
    }

    @Test
    void testUnexpectedCharacterDelimiter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:4?5"));
    }

    @Test
    void testDecimalNumber() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:1.743,5"));
    }

    @Test
    void testZeroIncluded() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:0,5"));
    }

    @Test
    void testNegativeNumbersMixed() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:-4,5"));
    }

    @Test
    void testUnexpectedSpecialCharacter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,?:4,5"));
    }

    @Test
    void testInvalidCharacterInMixedInput() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:ㅁ,5"));
    }
}
