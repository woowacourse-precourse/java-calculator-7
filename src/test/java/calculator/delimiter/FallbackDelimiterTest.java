package calculator.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FallbackDelimiterTest {

    private FallbackDelimiter fallbackDelimiter;

    @BeforeEach
    void setUp() {
        this.fallbackDelimiter = new FallbackDelimiter();
    }

    @Test
    @DisplayName("공백 문자열은 0을 반환한다.")
    void testTokenize_EmptyOrWhitespaceInput() {
        List<String> result = fallbackDelimiter.tokenize("");
        assertThat(result).isEqualTo(List.of());
    }

    @ParameterizedTest
    @CsvSource(delimiter = '=', value = {
            "1=1",
            "   2   =2",
            "999=999"
    })
    @DisplayName("단일 숫자는 그대로 반환한다.")
    void testTokenize_SingleNumber(String input, String expected) {
        List<String> result = fallbackDelimiter.tokenize(input);
        assertThat(result).isEqualTo(List.of(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "1", "   2   "})
    @DisplayName("공백 또는 숫자일 때 applicable은 true를 반환한다.")
    void testApplicable_ValidInput(String input) {
        assertThat(fallbackDelimiter.applicable(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "$12"})
    @DisplayName("숫자가 아닌 입력일 때 applicable은 false를 반환한다.")
    void testApplicable_InvalidInput(String input) {
        assertThat(fallbackDelimiter.applicable(input)).isFalse();
    }
}
