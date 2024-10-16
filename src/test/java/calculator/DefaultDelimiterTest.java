package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.delimiter.DefaultDelimiter;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultDelimiterTest {

    @Test
    @DisplayName("공백 문자열은 0을 반환한다.")
    void testExtractNumbers_EmptyOrWhitespaceInput() {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
        List<Integer> result = defaultDelimiter.extractNumbers("");
        assertThat(result).isEqualTo(List.of(0));
    }

    @ParameterizedTest
    @CsvSource(delimiter = '=', value = {
            "1=1",
            "   2   =2",
            "999=999"
    })
    @DisplayName("단일 숫자는 그대로 반환한다.")
    void testExtractNumbers_SingleNumber(String input, int expected) {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
        List<Integer> result = defaultDelimiter.extractNumbers(input);
        assertThat(result).isEqualTo(List.of(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "$12"})
    @DisplayName("숫자가 아닌 입력은 NumberFormatException을 발생시킨다.")
    void testExtractNumbers_InvalidInput(String input) {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
        assertThrows(NumberFormatException.class, () -> defaultDelimiter.extractNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "1", "   2   "})
    @DisplayName("공백 또는 숫자일 때 applicable은 true를 반환한다.")
    void testApplicable_ValidInput(String input) {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
        assertThat(defaultDelimiter.applicable(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "$12"})
    @DisplayName("숫자가 아닌 입력일 때 applicable은 false를 반환한다.")
    void testApplicable_InvalidInput(String input) {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
        assertThat(defaultDelimiter.applicable(input)).isFalse();
    }
}
