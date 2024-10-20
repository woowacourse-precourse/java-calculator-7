package calculator.domain.calculator.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    @Nested
    @DisplayName("구분자 파서 테스트")
    class ParseTests {

        @Test
        @DisplayName("기본 패턴을 반환한다.")
        void returnDefaultPattern() {
            assertEquals(",|:", DelimiterParser.parse(null));
            assertEquals(",|:", DelimiterParser.parse(""));
            assertEquals(",|:", DelimiterParser.parse("1,2,3"));
        }

        @Test
        @DisplayName("커스텀 구분자를 포함한 패턴을 반환한다.")
        void returnPatternWithCustomDelimiter() {
            assertEquals(",|:|;", DelimiterParser.parse("//;\\n1;2;3"));
            assertEquals(",|:|@", DelimiterParser.parse("//@\\n1@2@3"));
        }

        @Test
        @DisplayName("여러 커스텀 구분자를 포함한 패턴을 반환한다.")
        void returnPatternWithMultipleCustomDelimiters() {
            assertEquals(",|:|;|@", DelimiterParser.parse("//;|@\\n1;2@3"));
        }

        @Test
        @DisplayName("특수 문자를 포함한 커스텀 구분자를 올바르게 처리한다.")
        void handleSpecialCharactersInCustomDelimiter() {
            assertEquals(",|:|\\*", DelimiterParser.parse("//*\\n1*2*3"));
            assertEquals(",|:|\\+", DelimiterParser.parse("//+\\n1+2+3"));
            assertEquals(",|:|\\.", DelimiterParser.parse("//.\\n1.2.3"));
        }

        @Test
        @DisplayName("올바르지 않은 커스텀 구분자 형식에 대해 예외를 발생시킨다.")
        void throwExceptionForInvalidCustomDelimiterFormat() {
            assertThrows(IllegalArgumentException.class, () -> DelimiterParser.parse("//;1;2;3"));
        }
    }
}