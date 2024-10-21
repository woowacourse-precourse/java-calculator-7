package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    // 성공 케이스
    @Test
    @DisplayName("단일 숫자 입력")
    void testSingleNumber() {
        assertEquals("결과 : 1", StringCalculator.calculate("1"));
    }

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론)로 구분된 여러 숫자 입력")
    void testMultipleNumbersWithDefaultDelimiters() {
        assertEquals("결과 : 6", StringCalculator.calculate("1,2:3"));
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자 입력")
    void testMultipleNumbersWithComma() {
        assertEquals("결과 : 6", StringCalculator.calculate("1,2,3"));
    }

    @Test
    @DisplayName("커스텀 구분자 사용")
    void testCustomDelimiter() {
        assertEquals("결과 : 1", StringCalculator.calculate("//;\n1"));
    }

    @Test
    @DisplayName("혼합된 구분자 사용")
    void testMixedDelimitersWithCustom() {
        assertEquals("결과 : 10", StringCalculator.calculate("//;\n1;2,3:4"));
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 여러 숫자 입력")
    void testCustomDelimiterWithMultipleNumbers() {
        assertEquals("결과 : 15", StringCalculator.calculate("//;\n1;2;3;4;5"));
    }

    @Test
    @DisplayName("연속된 구분자 처리")
    void testSequentialDelimiters() {
        assertEquals("결과 : 5", StringCalculator.calculate("2,::3"));
    }

    // 실패 케이스
    @Test
    @DisplayName("잘못된 커스텀 구분자 형식에 대한 예외 처리")
    void testInvalidCustomDelimiterFormat() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;1"));
    }

    @Test
    @DisplayName("누락된 커스텀 구분자 처리")
    void testMissingCustomDelimiter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate(";\\n1"));
    }

    @Test
    @DisplayName("음수 값 포함 시 예외 발생")
    void testNegativeNumbers() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("-1,2,3"));
    }

    @Test
    @DisplayName("숫자가 아닌 입력 시 예외 발생")
    void testNonNumericInput() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("a"));
    }

    @Test
    @DisplayName("알파벳과 숫자가 혼합된 입력 시 예외 발생")
    void testMixedAlphaNumericInput() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("a,1"));
    }

    @Test
    @DisplayName("커스텀 구분자와 알파벳이 포함된 경우 예외 발생")
    void testCustomDelimiterWithAlphaCharacters() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\\n1;2,3:a"));
    }

    @Test
    @DisplayName("커스텀 구분자에 비숫자 문자가 포함된 경우 예외 발생")
    void testCustomDelimiterWithNonNumericCharacters() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\\n1;2;ㅁ;4;5"));
    }

    @Test
    @DisplayName("미확인 구분자가 포함된 경우 예외 발생")
    void testUnknownDelimiter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("//;\\n1;2,3:4?5"));
    }

    @Test
    @DisplayName("예상치 못한 특수 문자가 포함된 경우 예외 발생")
    void testUnexpectedCharacterDelimiter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:4?5"));
    }

    @Test
    @DisplayName("소수 포함 시 예외 발생")
    void testDecimalNumber() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:1.743,5"));
    }

    @Test
    @DisplayName("제로 포함 시 예외 발생")
    void testZeroIncluded() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:0,5"));
    }

    @Test
    @DisplayName("혼합된 음수 포함 시 예외 발생")
    void testNegativeNumbersMixed() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:-4,5"));
    }

    @Test
    @DisplayName("예상치 못한 특수 문자 포함 시 예외 발생")
    void testUnexpectedSpecialCharacter() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,?:4,5"));
    }

    @Test
    @DisplayName("혼합 입력에서 잘못된 문자 포함 시 예외 발생")
    void testInvalidCharacterInMixedInput() {
        assertThrows(InvalidInputException.class, () -> StringCalculator.calculate("1,2,3:ㅁ,5"));
    }
}
