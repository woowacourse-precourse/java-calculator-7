package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DelimiterExtractorTest {

    private final String positiveNumberPattern = "[0-9]+\\.?[0-9]*";

    @Test
    void 잘못된_커스텀_구분자가_있으면_IllegalArgumentException_예외가_발생한다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("//;\n1;2$3");

        assertThrows(IllegalArgumentException.class, () -> delimiterExtractor.validate(positiveNumberPattern));
    }

    @Test
    void 잘못된_기본_구분자가_있으면_IllegalArgumentException_예외가_발생한다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("1,2:3-4");

        assertThrows(IllegalArgumentException.class, () -> delimiterExtractor.validate(positiveNumberPattern));
    }

    @Test
    void 커스텀_구분자_문자열에서_사용자가_정의한_구분자를_추출한다() {
        String input = "//;\n1;2;3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        String input2 = "//-\n1-2-3";
        DelimiterExtractor delimiterExtractor2 = new DelimiterExtractor(input2);

        assertEquals(";", delimiterExtractor.extractCustomDelimiter());
        assertEquals("-", delimiterExtractor2.extractCustomDelimiter());
    }

    @Test
    void 커스텀_구분자_문자열에_사용된_구분자를_추출한다() {
        String input = "//;\n1;2;3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        String delimiterLeft = delimiterExtractor.remove(positiveNumberPattern);

        String expected = " ; ; ";
        assertEquals(expected, delimiterLeft);
    }

    @Test
    void 기본_구분자_문자열에_사용된_구분자를_추출한다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("1,2:3-4");

        String delimiterLeft = delimiterExtractor.remove(positiveNumberPattern);
        String expected = " , : - ";
        assertEquals(expected, delimiterLeft);
    }

    @Test
    void 커스텀_구분자를_사용한_경우_구분자_타입은_CUSTOM_이다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("//;\n1;2;3");

        DelimiterType type = delimiterExtractor.type();

        assertEquals(DelimiterType.CUSTOM, type);
    }

    @Test
    void 기본_구분자를_사용한_경우_구분자_타입은_BASIC_이다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("1,2:3");

        DelimiterType type = delimiterExtractor.type();

        assertEquals(DelimiterType.BASIC, type);
    }

    @Test
    void 문자열에_구분자가_없으면_문자열을_그대로_반환한다() {
        String input = "";

        String result = "1:2,3";
        if (!DelimiterExtractor.hasDelimiter(positiveNumberPattern, input)) {
            result = input;
        }

        assertEquals(input, result);
    }

    @Test
    void 문자열에_구분자가_없는_경우() {
        String empty = "";
        String positiveNumber = "12.345";

        assertFalse(DelimiterExtractor.hasDelimiter(positiveNumberPattern, empty));
        assertFalse(DelimiterExtractor.hasDelimiter(positiveNumberPattern, positiveNumber));
    }
}
