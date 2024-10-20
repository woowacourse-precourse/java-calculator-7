package calculator.util.regex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("정규식 테스트")
class RegexTest {

    @Test
    @DisplayName("정규식에 메타문자가 아닌 문자를 더한다")
    void 성공_정규식_메타문자X() {
        // Given
        Regex regex = new Regex("a");

        // When
        regex.add("b");

        // Then
        Regex expectedRegex = new Regex("a|\\Qb\\E");
        assertThat(regex).isEqualTo(expectedRegex);
    }

}
