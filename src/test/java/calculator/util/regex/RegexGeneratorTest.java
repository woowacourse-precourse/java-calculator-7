package calculator.util.regex;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.delimiter.Delimiter;
import calculator.domain.delimiter.Delimiters;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("정규식 생성기 테스트")
class RegexGeneratorTest {

    @Test
    @DisplayName("여러 구분자가 주어질 때, 모든 구분자를 포함하는 정규식을 생성한다")
    void 성공_구분자정규식생성_여러구분자() {
        // Given
        Delimiters delimiters = new Delimiters(new ArrayList<>(Arrays.asList(
                new Delimiter(","),
                new Delimiter(":"),
                new Delimiter("!")
        )));
        RegexGenerator regexGenerator = new RegexGenerator();

        // When
        Regex regex = regexGenerator.makeDelimiterAreaRegex(delimiters);

        // Then
        String expectedRegex = "//(.+?)\\\\n|\\Q,\\E|\\Q:\\E|\\Q!\\E";
        assertThat(regex.getRegex()).isEqualTo(expectedRegex);
    }
    
}
