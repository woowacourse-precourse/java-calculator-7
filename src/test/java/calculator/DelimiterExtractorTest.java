package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DelimiterExtractorTest {

    @Test
    void 문자열에_구분자가_없으면_문자열을_그대로_반환한다() {
        String positiveNumberPattern = "[0-9]+\\.?[0-9]*";
        String input = "";

        String result = "1:2,3";
        if (!DelimiterExtractor.hasDelimiter(positiveNumberPattern, input)) {
            result = input;
        }

        assertEquals(input, result);

    }

    @Test
    void 문자열에_구분자가_없는_경우() {
        String positiveNumberPattern = "[0-9]+\\.?[0-9]*";

        String empty = "";
        String positiveNumber = "12.345";

        assertFalse(DelimiterExtractor.hasDelimiter(positiveNumberPattern, empty));
        assertFalse(DelimiterExtractor.hasDelimiter(positiveNumberPattern, positiveNumber));
    }
}
