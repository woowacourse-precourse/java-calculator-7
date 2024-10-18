package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberExtractorTest {

    @Test
    @DisplayName("문자열 추출 테스트")
    void extractNumber() {
        // given
        String text = "1:22,32:4";

        // when
        NumberExtractor extractor = new NumberExtractor(text);

        // then
        assertThat(extractor.extractNumber()).isEqualTo(59);
    }

    @Test
    @DisplayName("공백 입력시 0을 출력한다.")
    void extractNumberWithSpace() {
        // given
        String text = "";

        // when
        NumberExtractor extractor = new NumberExtractor(text);

        // then
        assertThat(extractor.extractNumber()).isEqualTo(59);
    }
}