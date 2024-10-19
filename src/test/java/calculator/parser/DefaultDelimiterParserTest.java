package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.view.input.parser.DefaultDelimiterParser;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("DefaultDelimiterParser 기능 테스트")
public class DefaultDelimiterParserTest {
    private final DefaultDelimiterParser defaultDelimiterParser = new DefaultDelimiterParser();

    @DisplayName("기본 구분자로 문자열을 숫자로 구분한다.")
    @Test
    void success() {
        String input = "1,2:3";
        List<Integer> numbers = defaultDelimiterParser.parseInputNumbers(input);
        List<Integer> expect = List.of(1, 2, 3);
        assertThat(numbers).isEqualTo(expect);
    }

}
