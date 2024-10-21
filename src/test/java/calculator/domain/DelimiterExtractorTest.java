package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    @Test
    @DisplayName("구분자 추출 - 커스텀 구분자가 없는 경우")
    void extractBasicDelimiter() {
        //given
        String input = "1:2;3";
        String expected = ",:";

        //when
        String actual = delimiterExtractor.extract(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자 추출 - 커스텀 구분자가 있는 경우")
    void extractDelimiterWithCustomDelimiter() {
        //given
        String input = "//;\\n1";
        String expected = ",:;";

        //when
        String actual = delimiterExtractor.extract(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}