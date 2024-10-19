package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    private final DelimiterParser delimiterParser = new DelimiterParser(new DelimiterManager());

    @Test
    void 등록된_구분자를_기준으로_숫자_분리_테스트() {
        String input = "1:2,3";
        assertThat(delimiterParser.parse(input)).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 커스텀_구분자만_파싱해서_반환하는지_테스트() {
        String input = "//;\n1;2;3";
        assertThat(delimiterParser.parseCustomDelimiter(input)).isEqualTo(";");
    }

    @Test
    void 커스텀_구분자_등록부분을_제외한_나머지만_파싱해서_반환하는지_테스트() {
        String input = "//;\n1;2;3";
        assertThat(delimiterParser.removeCustomDelimiter(input)).isEqualTo("1;2;3");
    }
}