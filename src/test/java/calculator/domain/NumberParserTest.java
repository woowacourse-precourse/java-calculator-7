package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class NumberParserTest {
    private NumberParser parser;

    @BeforeEach
    void setUp() {
        parser = new NumberParser(new Validator());
    }

    @Test
    void 문자열_리스트를_정수로_변환() {
        // given
        List<String> input = List.of("1", "2", "3");
        // when
        List<Integer> result = parser.parseToIntegers(input);
        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 정수_변환_실패_예외() {
        // given
        List<String> input = List.of("1", "a", "3");
        // when
        assertThatThrownBy(() -> parser.parseToIntegers(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBER_MSG);
    }

    @Test
    void 음수_포함_예외() {
        // given
        List<String> input = List.of("1", "-2", "3");
        // when
        assertThatThrownBy(() -> parser.parseToIntegers(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NEGATIVE_NUMBER_MSG);
    }
}

