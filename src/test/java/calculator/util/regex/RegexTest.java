package calculator.util.regex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("정규식 테스트")
class RegexTest {

    @Test
    @DisplayName("정규식에 문자를 더한다")
    void 성공_정규식_문자() {
        // Given
        Regex regex = new Regex("a");

        // When
        regex.add("b");

        // Then
        Regex expectedRegex = new Regex("a\\Qb\\E");
        assertThat(regex).isEqualTo(expectedRegex);
    }

    @Test
    @DisplayName("정규식에 문자를 이어서 더한다")
    void 성공_정규식_이어진문자() {
        // Given
        Regex regex = new Regex("a");

        // When
        regex.addContinuously("b");

        // Then
        Regex expectedRegex = new Regex("a|\\Qb\\E");
        assertThat(regex).isEqualTo(expectedRegex);
    }

}
