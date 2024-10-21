package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor extractor = new DelimiterExtractor();

    @Test
    @DisplayName("커스텀 구분자가 있을 때 올바르게 구분자를 추출한다")
    void extractCustomDelimiterCorrectly() {
        String input = "//;\\n1;2;3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\\n");

        assertEquals(",|:|\\Q;\\E", result);
    }
}
