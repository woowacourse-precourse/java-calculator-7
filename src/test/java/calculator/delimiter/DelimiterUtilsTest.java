package calculator.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DelimiterUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "'a b c', 'abc'",
            "'   123   ', '123'",
            "'noSpace', 'noSpace'",
            "' a b ', 'ab'"
    })
    @DisplayName("문자열에서 모든 공백을 제거한다.")
    void testRemoveSpaces(String input, String expected) {
        String result = DelimiterUtils.removeSpaces(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "'.*+?^$(){}[]|\\', '\\.\\*\\+\\?\\^\\$\\(\\)\\{\\}\\[\\]\\|\\\\'",
            "'hello', 'hello'",
            "'a|b', 'a\\|b'",
            "'123$', '123\\$'"
    })
    @DisplayName("정규식 특수 문자를 이스케이프 처리한다.")
    void testReplaceSpecialCharacters(String input, String expected) {
        String result = DelimiterUtils.replaceSpecialCharacters(input);
        assertThat(result).isEqualTo(expected);
    }

}