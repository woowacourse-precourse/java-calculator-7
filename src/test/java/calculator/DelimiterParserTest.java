package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    private final DelimiterParser delimiterParser = new DelimiterParser(new DelimiterManager());

    @Test
    void 등록된_구분자를_기준으로_숫자_분리_테스트(){
        String input = "1:2,3";
        assertThat(delimiterParser.parse(input)).isEqualTo(List.of(1, 2, 3));
    }
}