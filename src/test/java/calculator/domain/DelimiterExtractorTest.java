package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterExtractorTest {

    @Test
    @DisplayName("구분자가 없는 경우 기본 구분자 반환 테스트")
    void testExtractEmptyDelimitersSuccess() {
        // given
        String input = "1,2:3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> expected = Set.of(',', ':');

        // when
        Set<Character> actual = delimiterExtractor.extractDelimiters(input);

        // then
        assertThat(actual).hasSize(expected.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(chars = {'[', ']', '-', '+', 'a', '0', '?', '/', '\\', '"', '\'', ';', '.', '<', '>', '!', '@', '#',
            '$', '%', '^', '&', '*', '(', ')', '='})
    @DisplayName("구분자가 있는 경우 구분자 포함 반환 테스트")
    void testExtractDelimitersSuccess(char delimiter) {
        // given
        String input = "//" + delimiter + "\\n";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> expected = Set.of(',', ':', delimiter);

        // when
        Set<Character> actual = delimiterExtractor.extractDelimiters(input);

        // then
        assertThat(actual).hasSize(expected.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//,\\n", "//:\\n", "//\\n"})
    @DisplayName("기본 구분자나 빈 문자열이 입력에 들어 온 경우 테스트")
    void testExtractDefaultDelimitersSuccess(String input) {
        // given
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> expected = Set.of(',', ':');

        // when
        Set<Character> actual = delimiterExtractor.extractDelimiters(input);

        // then
        assertThat(actual).hasSize(expected.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {";\\n", "/;\\n"})
    @DisplayName("왼쪽 패턴('//')이 없는 경우 테스트")
    void testExtractDelimitersWrongLeftPatternFail(String input) {
        // given
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> expected = Set.of(',', ':');

        // when
        Set<Character> actual = delimiterExtractor.extractDelimiters(input);

        //then
        assertThat(actual).hasSize(expected.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\", "//;n1,2;3", "//;1,2;3", "//;\n1,2;3"})
    @DisplayName("오른쪽 패턴('\n')이 없는 경우 테스트")
    void testExtractDelimitersWrongRightPatternFail(String input) {
        // given
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Set<Character> expected = Set.of(',', ':');

        // when
        Set<Character> actual = delimiterExtractor.extractDelimiters(input);

        // then
        assertThat(actual).hasSize(expected.size()).isEqualTo(expected);
    }
}
