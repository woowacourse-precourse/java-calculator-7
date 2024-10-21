package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterTest {

    @Test
    @DisplayName("커스텀 구분자에 '\'이 입력되어도 정상적으로 처리되는가?")
    void checkExpresstionContiansExcapeCharacter() {
        //given
        String input = "//\\\\n11";
        Delimiter delimiter= new CustomDelimiter();
        //when
        //then
        assertEquals("11", delimiter.parseDelimiter(input));
        assertEquals(",|:"+"|"+"\\\\", delimiter.getDelimiters());
    }

    @Test
    @DisplayName("커스텀 구분자를 바르게 추출하는가?")
    void canExtractCustomDelimiterProperly() {
        //given
        String input = "//!\\n11";
        Delimiter delimiter= new CustomDelimiter();
        //when
        //then
        assertEquals("11", delimiter.parseDelimiter(input));
        assertEquals(",|:"+"|"+"!", delimiter.getDelimiters());
    }
}
