package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.view.input.parser.CustomDelimiterParser;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("CustomDelimiterParser 기능 테스트")
public class CustomDelimiterParserTest {
    private final CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser();

    @DisplayName("커스텀 구분자로 문자열을 숫자로 구분한다.")
    @Test
    void success() {
        String input = "//;\\n3;4;5";
        List<Integer> numbers = customDelimiterParser.parseInputNumbers(input);
        List<Integer> expect = List.of(3, 4, 5);
        assertThat(numbers).isEqualTo(expect);
    }
}
