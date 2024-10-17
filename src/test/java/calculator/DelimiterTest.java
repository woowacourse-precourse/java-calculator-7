package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    static final String DEFAULT_COMMA = ",";
    static final String DEFAULT_COLON = ":";

    @Test
    @DisplayName("기본 구분자를 모두 반환해야 한다")
    void getAllDefaultDelimitersTest() {
        // given
        Delimiter defaultDelimiter = Delimiter.getDefault();

        // when
        List<String> delimiters = defaultDelimiter.findAll();

        // then
        assertThat(delimiters).containsAll(List.of(DEFAULT_COMMA, DEFAULT_COLON));
    }

    @Test
    @DisplayName("커스텀 구분자를 추가하면 기본 구분자를 포함한 구분자를 모두 반화해야 한다.")
    void getAllDelimitersWithCustomDelimiterTest() {
        // given
        String customDelimiter = "-";
        Delimiter delimiter = Delimiter.from(customDelimiter);

        // when
        List<String> delimiters = delimiter.findAll();

        // then
        assertThat(delimiters).containsAll(List.of(DEFAULT_COMMA, DEFAULT_COLON, customDelimiter));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "9"})
    @DisplayName("커스텀 구분자가 숫자라면 예외가 발생해야 한다.")
    void numericCustomDelimiterExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> Delimiter.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {DEFAULT_COMMA, DEFAULT_COLON})
    @DisplayName("커스텀 구분자가 기본 구분자와 중복된다면 예외가 발생해야 한다.")
    void duplicatedDefaultDelimiterExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> Delimiter.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\1", "/;\n1", "//;\\ n1", ";//;\\n1"})
    @DisplayName("유효하지 않은 구분자 등록 문자가 존재하면 예외가 발생해야 한다.")
    void invalidDelimiterPrefixAndSuffixExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> DelimiterExtractor.extract(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//\\n1", "//;;\\n1", "//;;;;;\\n1"})
    @DisplayName("커스텀 구분자가 없거나 두 개 이상이면 예외가 발생해야 한다.")
    void invalidDelimitersCountExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> DelimiterExtractor.extract(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
