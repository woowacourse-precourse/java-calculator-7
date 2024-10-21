package calculator;

import calculator.parser.DelimiterConfig;
import calculator.parser.StringDelimiterParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDelimiterParserTest {

    private final StringDelimiterParser parser = new StringDelimiterParser(DelimiterConfig.DEFAULT);

    @Test
    @DisplayName("기본 구분자를 사용한 문자열 파싱 테스트")
    void success_parseDefaultDelimiters() {
        // given
        String input = "1,2:3";

        // when
        String[] result = parser.parseToNumberStrings(input);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 문자열 파싱 테스트")
    void success_parseCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        String[] result = parser.parseToNumberStrings(input);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("빈 문자열에 대한 파싱 테스트")
    void success_parseEmptyString() {
        // given
        String input = "";

        // when
        String[] result = parser.parseToNumberStrings(input);

        // then
        assertArrayEquals(new String[0], result);
    }

    @Test
    @DisplayName("커스텀, 기본 구분자를 혼합 사용한 문자열 파싱 테스트")
    void success_parseCustomAndDefaultDelimiter() {
        // given
        String input = "//;\\n1,2;3";

        // when
        String[] result = parser.parseToNumberStrings(input);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("커스텀, 기본 구분자를 혼합 사용, 그리고 양측 공백이 있는 문자열 파싱 테스트")
    void success_parseCustomAndDefaultDelimiterAndSideBlank() {
        // given
        String input = "   //;\\n1,2;3   ";

        // when
        String[] result = parser.parseToNumberStrings(input);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("커스텀 구분자가 emtpy(길이 = 0)인 문자열 파싱 테스트")
    void fail_emptyDelimiter() {
        // given
        String input = "//\\n1,2;3";

        // when & then
        assertThrows(IllegalArgumentException.class,
            () -> parser.parseToNumberStrings(input), "커스텀 구분자는 공백을 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자에 금지된 문자(','나 ':')가 포함된 경우 예외 테스트")
    void fail_invalidDelimiterCharacters() {
        // given
        String input = "//#,#\\n1#,#2:3";

        // when & then
        assertThrows(IllegalArgumentException.class,
            () -> parser.parseToNumberStrings(input), "커스텀 구분자는 ','을 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자가 포함된 경우 예외 테스트")
    void fail_numberDelimiter() {
        // given
        String input = "//1#\\n1,2,3";

        // when & then
        assertThrows(IllegalArgumentException.class,
            () -> parser.parseToNumberStrings(input), "커스텀 구분자는 숫자를 포함할 수 없습니다.");
    }
}