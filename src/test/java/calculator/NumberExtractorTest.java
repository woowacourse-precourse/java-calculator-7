package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberExtractorTest {

    @Test
    @DisplayName("default 문자열 추출 테스트")
    void extractNumber() {
        // given
        String text = "1:22,32:4";

        // when
        NumberExtractor extractor = new NumberExtractor();
        int extractNumber = extractor.defaultDelimiterExtractNumber(text);

        // then
        Assertions.assertEquals(extractNumber, 59);
    }
}