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

    @Test
    @DisplayName("기본 구분자만 있을 때 기본 구분자를 반환한다")
    void extractDefaultDelimiters() {
        String input = "1,2:3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\n");

        assertEquals(",|:", result);
    }

    @Test
    @DisplayName("커스텀 구분자가 역순으로 있을 때 구분자를 올바르게 추출한다")
    void extractReversedCustomDelimiter() {
        String input = "\\n;//1;2;3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\\n");

        assertEquals(",|:|\\Q;\\E", result);  // 커스텀 구분자가 없으면 기본 구분자만 포함
    }


}
