package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3:4", "1,2,3,4", "1,2:3,4"})
    @DisplayName("커스텀 구분자를 지정하지 않으면, 기본 구분자를 통해 숫자를 파싱해야 한다.")
    void parseByDefaultDelimiterTest(String value) {
        // given
        Delimiter delimiters = Delimiter.getDefault();
        NumberParser parser = NumberParser.from(delimiters);

        // when
        Numbers numbers = parser.parse(value);

        // then
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1:2;3", "//+\\n1+2+3", "// \\n1 2 3", "//-\\n1-2-3"})
    @DisplayName("커스텀 구분자를 지정하면, 기본 및 커스텀 구분자를 통해 숫자를 파싱해야 한다.")
    void parseByCustomDelimiterTest(String value) {
        // given
        String delimiter = DelimiterExtractor.extract(value);
        Delimiter delimiters = Delimiter.from(delimiter);
        NumberParser parser = NumberParser.from(delimiters);

        // when
        Numbers numbers = parser.parse(value);

        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("빈 문자열이라면 빈 숫자를 반환해야 한다.")
    void parseEmptyTest() {
        // given
        String empty = "";
        Delimiter delimiter = Delimiter.getDefault();
        NumberParser parser = NumberParser.from(delimiter);

        // when
        Numbers numbers = parser.parse(empty);

        // then
        assertThat(numbers.size()).isZero();
    }

    @Test
    @DisplayName("공백이라면 빈 숫자를 반환해야 한다.")
    void parseBlankTest() {
        // given
        String blank = " ";
        Delimiter delimiter = Delimiter.getDefault();
        NumberParser parser = NumberParser.from(delimiter);

        // when
        Numbers numbers = parser.parse(blank);

        // then
        assertThat(numbers.size()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2-3","1 2,3", ",1,2,3", "1,2:3:"})
    @DisplayName("파싱할 수 없는 문자열인 경우 예외가 발생해야 한다.")
    void invalidStringExceptionWithDefaultTest(String value) {
        // given
        Delimiter delimiter = Delimiter.getDefault();
        NumberParser parser = NumberParser.from(delimiter);

        // when, then
        assertThatThrownBy(() -> parser.parse(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1 2;3", "//;\\n1,2,3,", "//;\\,1,2,3"})
    @DisplayName("커스텀 구분자가 포함되었지만, 파싱할 수 없는 문자열인 경우 예외가 발생해야 한다.")
    void invalidStringExceptionWithCustomTest(String value) {
        // given
        Delimiter delimiter = Delimiter.from(value);
        NumberParser parser = NumberParser.from(delimiter);

        // when, then
        assertThatThrownBy(() -> parser.parse(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
