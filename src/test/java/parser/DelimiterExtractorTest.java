package parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    @Test
    void 기본_구분자() {
        String input = "1,2:3";
        String delimiter = delimiterExtractor.extractDelimiter(input);
        assertThat(delimiter).isEqualTo(",|:");
    }

    @Test
    void 커스텀_구분자_세미콜론() {
        String input = "//;\n1;2;3";
        String delimiter = delimiterExtractor.extractDelimiter(input);
        assertThat(delimiter).isEqualTo(Pattern.quote(";"));
    }

    @Test
    void 커스텀_구분자_문자열() {
        String input = "//abcdef\n1;2;3";
        String delimiter = delimiterExtractor.extractDelimiter(input);
        assertThat(delimiter).isEqualTo(Pattern.quote("abcdef"));
    }

    @Test
    void 커스텀_구분자_공백() {
        String input = "// \n1;2;3";
        String delimiter = delimiterExtractor.extractDelimiter(input);
        assertThat(delimiter).isEqualTo(Pattern.quote(" "));
    }

    @Test
    void 커스텀_구분자_선언_후_개행_없으면_예외() {
        String input = "//;";
        assertThatThrownBy(() -> delimiterExtractor.extractDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자 선언 후 개행이 필요합니다.");
    }

    @Test
    void 커스텀_구분자가_비어있으면_예외() {
        String input = "//\n1,2,3";
        assertThatThrownBy(() -> delimiterExtractor.extractDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 비어 있습니다.");
    }

}