package calculator.domain.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.util.regex.Regex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구분자 테스트")
class DelimiterTest {

    @Test
    @DisplayName("구분자가 정규식과 매치되면 true를 반환한다")
    void 성공_정규식매치_주어진정규식() {
        // Given
        Delimiter delimiter = new Delimiter("!");
        Regex regex = new Regex("[!@#$%^&]");

        // When & Then
        assertThat(delimiter.matches(regex)).isTrue();
    }

}
