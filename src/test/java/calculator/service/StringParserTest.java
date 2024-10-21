package calculator.service;

import calculator.domain.OriginalString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser;

    @BeforeEach
    void setUp() {
        stringParser = new StringParser();
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 경우, 구분자를 제외한 부분을 반환해야 한다.")
    void shouldReturnStringWithoutCustomDelimiter() {
        String input = "//;\\n1;2;3";
        OriginalString originalString = new OriginalString(input);

        String result = stringParser.parseInput(originalString, true);

        assertThat(result)
                .as("구분자를 제외한 문자열 1;2;3이 반환되어야 합니다.")
                .isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 경우, 원본 문자열을 그대로 반환해야 한다.")
    void shouldReturnOriginalStringWhenNoCustomDelimiter() {
        String input = "1,2,3";
        OriginalString originalString = new OriginalString(input);

        String result = stringParser.parseInput(originalString, false);

        assertThat(result)
                .as("원본 문자열 1,2,3이 그대로 반환되어야 합니다.")
                .isEqualTo("1,2,3");
    }

    @Test
    @DisplayName("빈 문자열이 입력된 경우, 빈 문자열을 반환해야 한다.")
    void shouldReturnEmptyStringWhenInputIsEmpty() {
        String input = "";
        OriginalString originalString = new OriginalString(input);

        String result = stringParser.parseInput(originalString, false);

        assertThat(result)
                .as("빈 문자열이 반환되어야 합니다.")
                .isEqualTo("");
    }

    @Test
    @DisplayName("커스텀 구분자가 있지만, 잘못된 형식일 경우 전체 문자열을 반환해야 한다.")
    void shouldReturnFullStringWhenNoSuffixInCustomDelimiter() {
        String input = "//;\\n";
        OriginalString originalString = new OriginalString(input);

        String result = stringParser.parseInput(originalString, true);

        assertThat(result)
                .as("구분자가 있지만 숫자가 없으므로 빈 문자열이 반환되어야 합니다.")
                .isEqualTo("");
    }
}
