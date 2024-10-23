package calculator.validate;

import static calculator.validate.StringValidate.isInputStartWithSlash;
import static calculator.validate.StringValidate.validateCalFormula;
import static calculator.validate.StringValidate.validateNewLineInput;
import static calculator.validate.StringValidate.validateNotNullInput;
import static calculator.validate.StringValidate.validateSeperator;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringValidateTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("null 입력 테스트")
    void inputWithNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> validateNotNullInput(input));
    }

    @ParameterizedTest
    @MethodSource("startWithSlashTestCases")
    @DisplayName("'//'로 문자열이 시작하는지 확인하는 테스트")
    void startWithSlash(String input, boolean expected) {
        Assertions.assertEquals(expected, isInputStartWithSlash(input));
    }

    @ParameterizedTest
    @MethodSource("endWithNewLineTestCases")
    @DisplayName("'\n', '\\n' 로 문자열이 끝나는지 확인하는 테스트")
    void newLineTest(String input, boolean shouldThrow) {
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> validateNewLineInput(input));
        } else {
            assertDoesNotThrow(() -> validateNewLineInput(input));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {",:[]1", "1,:abc"})
    @DisplayName("구분자에는 숫자가 있어서는 안된다.")
    void noNumInSeparator(String separator) {
        assertThrows(IllegalArgumentException.class, () -> validateSeperator(separator));
    }

    @ParameterizedTest
    @MethodSource("calFromulaTestCases")
    @DisplayName("계산할 문자열 검증 테스트")
    void validateCalFormulaTest(String string, String separator, boolean shouldThrow) {
        if (shouldThrow) {
            assertThrows(IllegalArgumentException.class, () -> validateCalFormula(string, separator));
        } else {
            assertDoesNotThrow(() -> validateCalFormula(string, separator));
        }
    }

    static Stream<Arguments> startWithSlashTestCases() {
        return Stream.of(
                Arguments.of("//abc", true),    // '//'으로 문자열이 시작한 경우
                Arguments.of("abc//", false)    // '//'으로 문자열이 시작하지 않은 경우
        );
    }

    static Stream<Arguments> endWithNewLineTestCases() {
        return Stream.of(
                Arguments.of("//test", true),   // '\n' 또는 '\\n' 으로 안끝나는 경우
                Arguments.of("test\n", false),  // '\n' 으로 끝나는 경우
                Arguments.of("test\\n", false)  // '\\n' 으로 끝나는 경우
        );
    }

    static Stream<Arguments> calFromulaTestCases() {
        return Stream.of(
                Arguments.of("1a2B3c", "abc", true),    // 계산식에 숫자, 구분자 외 다른 문자가 있는 경우
                Arguments.of("123456", "abc", false),           // 계산식에 숫자만 있는 경우
                Arguments.of("abcabc", "abc", false),           // 계산식에 구분자만 있는 경우
                Arguments.of("", "abc", false),                 // 계산식이 빈 경우
                Arguments.of("1234", "", false)                 // 구분자가 없는 경우
        );
    }
}
