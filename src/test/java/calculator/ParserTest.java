package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    private static final String ERROR_MESSAGE = "잘못된 숫자 입니다.";

    @Test
    @DisplayName("숫자형식으로 변환하다")
    void testParseToNumber() {
        //given
        String[] stringNumbers = {"1", "2"};
        Parser parser = new Parser();
        int[] expectedNumbers = {1, 2};
        //when
        int[] numbers = parser.parseToNumber(stringNumbers);
        //then
        assertThat(numbers).hasSize(expectedNumbers.length);
        assertThat(numbers).contains(expectedNumbers);
    }

    @Test
    @DisplayName("숫자형식 변환중 숫자가 아니면 예외가 발생한다")
    void failParseToNumber() {
        //given
        String[] invalidStringNumbers = {"1d", "2"};
        Parser parser = new Parser();
        //when
        //then
        assertThatThrownBy(() -> parser.parseToNumber(invalidStringNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);
    }

}