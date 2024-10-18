package calculator.extractor;

import calculator.extractor.result.StringDelimiterResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StringDelimiterExtractorTest {

    StringDelimiterExtractor stringDelimiterExtractor;

    @BeforeEach
    void before() {
        stringDelimiterExtractor = new StringDelimiterExtractor();
    }

    @Test
    void TDD_기본_구분자_반환() {
        //given
        String input = "1,2,3";

        //when
        StringDelimiterResult extractedResult = stringDelimiterExtractor.extract(input);
        Set<String> delimiters = extractedResult.getDelimiters();

        //then
        assertThat(delimiters).contains(":", ",");
    }

    @Test
    void TDD_커스텀_구분자_반환() {
        //given
        String input = "//|\\n1:2|3";

        //when
        StringDelimiterResult extractedResult = stringDelimiterExtractor.extract(input);
        Set<String> delimiters = extractedResult.getDelimiters();

        //then
        assertThat(delimiters).contains(":", ",", "|");
    }

    @Test
    void TDD_커스텀_구분자_존재시_계산_필요한_문자열_추출() {
        //given
        String input = "//|\\n1:2|3";

        //when
        StringDelimiterResult extractedResult = stringDelimiterExtractor.extract(input);
        String text = extractedResult.text();

        //then
        assertThat(text).isEqualTo("1:2|3");
    }

    @Test
    void 커스텀_구분자_문자열_반환() {
        //given
        String input = "//:\\n1:2|3";

        //when
        StringDelimiterResult extractedResult = stringDelimiterExtractor.extract(input);
        String customDelimiter = extractedResult.customDelimiter();

        //then
        assertThat(customDelimiter).isEqualTo(":");
    }
}
