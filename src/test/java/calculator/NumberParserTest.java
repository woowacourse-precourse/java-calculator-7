package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {
    private static final String ERROR_MESSAGE = "잘못된 숫자 입니다.";

    @Test
    @DisplayName("숫자형식으로 변환하다")
    void testParse() {
        //given
        List<String> stringToNumbers = List.of("1", "2");
        NumberParser numberParser = new NumberParser();
        List<Integer> expectedNumbers = stringToNumbers.stream().map(Integer::parseInt).toList();
        //when
        List<Integer> numbers = numberParser.parse(stringToNumbers);
        //then
        assertThat(numbers).hasSize(expectedNumbers.size());
        assertThat(numbers).containsAll(expectedNumbers);
    }

    @Test
    @DisplayName("숫자형식 변환중 숫자가 아니면 예외가 발생한다")
    void failParse() {
        //given
        List<String> invalidStringNumbers = List.of("1d", "2");
        NumberParser numberParser = new NumberParser();
        //when
        //then
        assertThatThrownBy(() -> numberParser.parse(invalidStringNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);
    }

}