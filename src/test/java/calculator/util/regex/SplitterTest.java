package calculator.util.regex;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.delimiter.Delimiter;
import calculator.domain.delimiter.Delimiters;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Splitter 테스트")
class SplitterTest {

    @Test
    @DisplayName("구분자로 문자열을 쪼갠다")
    void 성공_문자열쪼개기_주어진구분자() {
        // Given
        String input = "//!!\\n1!!2";
        Delimiters delimiters = new Delimiters(List.of(new Delimiter("!!")));
        Splitter splitter = new Splitter();

        // When
        List<String> splitInput = splitter.splitByDelimiters(input, delimiters);

        // Then
        assertThat(splitInput).containsAll(List.of("1", "2"));
    }

}
