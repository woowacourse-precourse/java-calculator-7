package calculator.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = StringCalculator.getInstance();
    }

    @Test
    @DisplayName("간단한 입력에 대한 덧셈 테스트")
    void testSumWithSimpleInput() {
        String input = "1,2,3";
        long result = stringCalculator.sum(input);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("사용자 정의 구분자를 사용하는 덧셈 테스트")
    void testSumWithCustomSeparator() {
        String input = "//;\\n1;2;3";
        long result = stringCalculator.sum(input);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("여러 사용자 정의 구분자를 사용하는 덧셈 테스트")
    void testSumWithMultipleCustomSeparators() {
        String input = "//:|;\\n1:2;3";
        long result = stringCalculator.sum(input);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("잘못된 문자가 포함된 입력에 대한 테스트")
    void testSumWithInvalidCharacters() {
        String input = "1,2,a";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.sum(input);
        });
        assertEquals("구분자가 아닌 값이 포함되어 있습니다: a", exception.getMessage());
    }

    @Test
    @DisplayName("연속된 구분자가 포함된 입력에 대한 테스트")
    void testSumWithConsecutiveSeparators() {
        String input = "1,,2";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.sum(input);
        });
        assertEquals("구분자가 연속으로 두 번 이상 나왔습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("마지막 글자가 구분자인 입력에 대한 테스트")
    void testSumWithTrailingSeparator() {
        String input = "1,2,";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.sum(input);
        });
        assertEquals("마지막 글자가 구분자입니다: ,", exception.getMessage());
    }

    @Test
    @DisplayName("빈 문자열에 대한 예외 테스트")
    void testSumWithEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.sum("");
        });
        assertEquals("빈 문자열입니다.", exception.getMessage());
    }
}