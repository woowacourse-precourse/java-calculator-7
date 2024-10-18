package calculator.parser.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.IllegalArgumentExceptionEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterParserTest {

    @Test
    @DisplayName("단일 커스텀 구분자 파싱 성공")
    void parseSingleCustomDelimiter() {
        // given
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser("//", "\\n");
        String input = "//;\\n1;2,3";

        // when
        Character delimiter = customDelimiterParser.getDelimiter(input);

        // then
        assertEquals(';', delimiter);
    }

    @Test
    @DisplayName("단일 문자 커스텀 구분자 'a' 파싱 성공")
    void parseCustomDelimiterA() {
        // given
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser("//", "\\n");
        String input = "//a\\n1;2,3";

        // when
        Character delimiter = customDelimiterParser.getDelimiter(input);

        // then
        assertEquals('a', delimiter);
    }

    @Test
    @DisplayName("여러 개의 커스텀 구분자 파싱 시 예외 발생")
    void parseWithMultipleCustomDelimitersThrowsException() {
        // given
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser("//", "\\n");
        String input = "//+\\n1;2,3//-\\n";

        // when
        assertThrows(IllegalArgumentException.class, () -> customDelimiterParser.getDelimiter(input),
                IllegalArgumentExceptionEnum.MULTIPLE_DELIMITERS.getMessage());
    }

    @Test
    @DisplayName("문자열 길이의 커스텀 구분자 파싱 시 예외 발생")
    void parseWithLongCustomDelimiterThrowsException() {
        // given
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser("//", "\\n");
        String input = "//++\\n1;2,3";

        // when
        assertThrows(IllegalArgumentException.class, () -> customDelimiterParser.getDelimiter(input),
                IllegalArgumentExceptionEnum.INVALID_LENGTH.getMessage());
    }

    @Test
    @DisplayName("빈 커스텀 구분자 파싱 시 예외 발생")
    void parseWithEmptyCustomDelimiterThrowsException() {
        // given
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser("//", "\\n");
        String input = "//\\n1;2,3";

        // when
        assertThrows(IllegalArgumentException.class, () -> customDelimiterParser.getDelimiter(input),
                IllegalArgumentExceptionEnum.INVALID_LENGTH.getMessage());
    }

    @Test
    @DisplayName("숫자로 된 커스텀 구분자 파싱 시 예외 발생")
    void parseWithNumericCustomDelimiterThrowsException() {
        // given
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser("//", "\\n");
        String input = "//1\\n1;2,3";

        // when
        assertThrows(IllegalArgumentException.class, () -> customDelimiterParser.getDelimiter(input),
                IllegalArgumentExceptionEnum.INVALID_CHARACTER.getMessage());
    }
}
