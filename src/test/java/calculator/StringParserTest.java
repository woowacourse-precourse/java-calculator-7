package calculator;

import calculator.model.StringParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser = new StringParser();

    @Test
    void 공백문자가_아닐시_false를_반환하다() {
        boolean expectedFalse = false;
        String notBlank = "Not Blank";

        boolean actual = stringParser.isBlank(notBlank);

        assertEquals(expectedFalse, actual);
    }

    @Test
    void 공백문자일시_true를_반환하다() {
        boolean expectedTrue = true;
        String blank = "";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedTrue, actual);
    }

    @Test
    void 쉼표는_구분자로_인식된다() {
        assertTrue(stringParser.isSeparator(","));
    }

    @Test
    void 콜론은_구분자로_인식된다() {
        assertTrue(stringParser.isSeparator(":"));
    }

    @Test
    void 구분자가_아닌_문자열은_false를_반환한다() {
        assertFalse(stringParser.isSeparator("a"));
        assertFalse(stringParser.isSeparator("1"));
        assertFalse(stringParser.isSeparator(" "));
    }

    @Test
    void 커스텀_구분자_추출_성공() {
        String input = "//;\n1;2;3";
        String customSeparator = stringParser.extractCustomSeparator(input);
        assertEquals(";", customSeparator);
    }

    @Test
    void 커스텀_구분자가_없을_때_null_반환() {
        String input = "1,2,3";
        String customSeparator = stringParser.extractCustomSeparator(input);
        assertNull(customSeparator);
    }

    @Test
    void 잘못된_커스텀_구분자_형식_예외_발생() {
        String input = "//;n1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractCustomSeparator(input);
        });
    }

    @Test
    void 커스텀_구분자_정의_제거_성공() {
        String input = "//;\n1;2;3";
        String result = stringParser.removeCustomSeparatorDefinition(input);
        assertEquals("1;2;3", result);
    }

    @Test
    void 커스텀_구분자가_없을_때_원본_문자열_반환() {
        String input = "1,2,3";
        String result = stringParser.removeCustomSeparatorDefinition(input);
        assertEquals(input, result);
    }

    @Test
    void 잘못된_커스텀_구분자_정의_제거시_예외_발생() {
        String input = "//;1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.removeCustomSeparatorDefinition(input);
        });
    }
}
