package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.global.exception.CalculatorException;
import calculator.global.exception.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    private DelimiterParser delimiterParser;

    @BeforeEach
    void setUp() {
        delimiterParser = new DelimiterParser();
    }

    @Test
    @DisplayName("기본 구분자 테스트")
    void testDefaultDelimiter() {
        assertEquals(",|:", delimiterParser.getDelimiter());
    }

    @Test
    @DisplayName("커스텀 구분자 파싱 테스트")
    void testParseCustomDelimiter() {
        String result = delimiterParser.parse("//;");
        assertEquals(";", result);
        assertEquals(";", delimiterParser.getDelimiter());
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 테스트 - '//'로 시작하지 않음")
    void testInvalidCustomDelimiterStart() {
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> delimiterParser.parse(";"));
        assertEquals(ErrorMessage.INVALID_DELIMITER_START.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 테스트 - 빈 구분자")
    void testEmptyCustomDelimiter() {
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> delimiterParser.parse("//"));
        assertEquals(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("복잡한 커스텀 구분자 테스트")
    void testComplexCustomDelimiter() {
        String result = delimiterParser.parse("//[***]");
        assertEquals("[***]", result);
        assertEquals("[***]", delimiterParser.getDelimiter());
    }
}