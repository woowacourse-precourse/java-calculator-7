package calculator.split;

import static calculator.split.StringSplit.getCalFormula;
import static calculator.split.StringSplit.getSeparator;
import static calculator.split.StringSplit.splitCalFormulaBySeparator;
import static calculator.split.StringSplit.stringToNumber;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringSplitTest {
    @ParameterizedTest
    @MethodSource("extractSeparatorTestCases")
    @DisplayName("구분자 문자열에서 구분자를 올바르게 추출하는지 검증한다.")
    void getCustomSeparator(String customSeparator, String stringWithCustomSeparator) {
        assertEquals(customSeparator, getSeparator(stringWithCustomSeparator));
    }

    @ParameterizedTest
    @MethodSource("extractCalFormulaTestCases")
    @DisplayName("계산해야 하는 문자열에서 계산식을 올바르게 추출하는지 검증한다.")
    void getCalForumula(String calFormula, String input) {
        assertEquals(calFormula, getCalFormula(input));
    }

    @ParameterizedTest
    @MethodSource("getSplitStringBySeparatorTestCases")
    @DisplayName("구분자로 계산식을 끊고, 배열을 반환한다.")
    void getNumArray(int[] expected, String calFormula, String separator) {
        assertArrayEquals(expected, splitCalFormulaBySeparator(calFormula, separator));
    }

    @ParameterizedTest
    @MethodSource("getStringToNumberTestCases")
    @DisplayName("문자열을 숫자로 변환한다.")
    void stringToNum(int num, String calFormula) {
        assertEquals(num, stringToNumber(calFormula));
    }

    static Stream<Arguments> extractSeparatorTestCases() {
        return Stream.of(
                Arguments.of("abc,:", "//abc\n123"),    // '\n' 으로 문자열을 분리한 경우
                Arguments.of("abc,:", "//abc\\n123"),           // '\\n' 으로 문자열을 분리한 경우
                Arguments.of(",:", "1:2,3"),                    // 문자열을 분리할 필요 없는 경우
                Arguments.of("abc,:", "//abc\n\n123")           // 처음으로 나오는 '\n' 으로 문자열을 분리한 경우
        );
    }

    static Stream<Arguments> extractCalFormulaTestCases() {
        return Stream.of(
                Arguments.of("123", "//abc\n123"),      // '\n' 으로 문자열을 분리한 경우
                Arguments.of("123", "//abc\\n123"),     // '\\n' 으로 문자열을 분리한 경우
                Arguments.of("\n123", "//abc\n\n123"),  // 처음으로 나오는 '\n' 으로 문자열을 분리한 경우
                Arguments.of("", "//abc\n"),            // '\n' 으로 문자열 뒤가 빈 경우
                Arguments.of("", "//abc\\n"),           // '\\n' 으로 문자열 뒤가 빈 경우
                Arguments.of("1,2::3", "1,2::3")        // 문자열을 분리할 필요가 없는 경우
        );
    }

    static Stream<Arguments> getSplitStringBySeparatorTestCases() {
        return Stream.of(
                Arguments.of(new int[]{12, 34, 5, 0}, "12a34b5c", "abc"),           // 구분자로 계산식을 올바르게 추출한 경우
                Arguments.of(new int[]{0}, "", "a"),                                // 계산식이 빈 경우
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0}, "abcabc", "abc")       // 구분자로만 계산식이 구성된 경우
        );
    }

    static Stream<Arguments> getStringToNumberTestCases() {
        return Stream.of(
                Arguments.of(12, "12"),
                Arguments.of(0, "") // 빈 문자열 0으로 변환
        );
    }
}
