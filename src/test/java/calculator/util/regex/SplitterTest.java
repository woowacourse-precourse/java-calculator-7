package calculator.util.regex;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Splitter 테스트")
class SplitterTest {

    @Test
    @DisplayName("주어진 정규식으로 문자열을 쪼갠다")
    void 성공_정규식으로문자열쪼개기_주어진정규식() {
        // Given
        String input = "//!!\\n1!!2";
        Regex regex = new Regex("//(.+?)\\\\n|\\Q,\\E|\\Q:\\E|\\Q!!\\E");
        Splitter splitter = new Splitter();

        // When
        List<String> splitInput = splitter.splitByDelimiters(input, regex);

        // Then
        assertThat(splitInput).containsAll(List.of("1", "2"));
    }

}
