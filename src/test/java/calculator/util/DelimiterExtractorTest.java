package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    @Test
    @DisplayName("기본 구분자를 사용할 경우 리스트로 반환한다.")
    void extractBasicDelimiter() {
        String input = "1,2,3";

        List<String> result = DelimiterExtractor.extract(input);
        assertThat(result).containsExactly(",");
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할 경우 리스트로 반환한다.")
    void extractCustomDelimiter() {
        String input = "//;\\n1;2;3";

        List<String> result = DelimiterExtractor.extract(input);
        assertThat(result).containsExactly(";");
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자를 같이 사용할 경우 리스트로 반환한다.")
    void extractMixedDelimiters() {
        String input = "//;\\n1;2,3,4";

        List<String> result = DelimiterExtractor.extract(input);
        assertThat(result).containsExactly(";", ",");
    }

    @Test
    @DisplayName("커스텀 구분자를 두 개 사용할 경우 리스트로 반환한다.")
    void extractMultipleCustomDelimiters() {
        String input = "//;\\n//&\\n1;2&3";

        List<String> result = DelimiterExtractor.extract(input);
        assertThat(result).containsExactly(";", "&");
    }

}
