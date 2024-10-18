package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser;

    @BeforeEach
    void setUp() {
        stringParser = new StringParser();
    }

    @ParameterizedTest
    @DisplayName("기본 구분자 쉼표(,)와 콜론(:) 으로 문자열을 파싱한다.")
    @ValueSource(strings = {"1,2:3"})
    void parse(String input) {
        String[] parseString = stringParser.parseString(input);
        assertThat(parseString).containsExactly("1", "2", "3");
    }
}
