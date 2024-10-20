package calculator;

import static calculator.CustomDelimiter.extractCustomDelimiter;
import static calculator.CustomDelimiter.isValidExpression;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterTest {

    @DisplayName("커스텀 구분자에 '\'이 입력되어도 정상적으로 처리되는가?")
    @Test
    void checkExpresstionContiansExcapeCharacter() {
        //given
        String input = "//\\\\n11";
        //when
        //then
        assertTrue(CustomDelimiter.isValidExpression(input));
        assertEquals("11", extractCustomDelimiter(input));
        assertEquals("\\\\", CustomDelimiter.getCustomDelimiter());
    }

    @DisplayName("커스텀 구분자를 바르게 추출하는가?")
    @Test
    void canExtractCustomDelimiterProperly() {
        //given
        String input = "//!\\n11";
        //when
        extractCustomDelimiter(input);
        //then
        assertTrue(CustomDelimiter.isValidExpression(input));
        assertEquals("11", CustomDelimiter.getResult());
        assertEquals("!", CustomDelimiter.getCustomDelimiter());
    }
}
