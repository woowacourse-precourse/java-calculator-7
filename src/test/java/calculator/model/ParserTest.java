package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    void 유효한_숫자_문자열_리스트_파싱() {
        // given
        List<String> input = List.of("1", "2", "3");

        // when
        List<Integer> result = parser.parseNum(input);

        // then
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void 음수_포함시_예외_발생() {
        // given
        List<String> input = List.of("1", "-2", "3");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseNum(input));
    }

    @Test
    void 숫자가_아닌_문자열_포함시_예외_발생() {
        // given
        List<String> input = List.of("1", "two", "3");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseNum(input));
    }


    @Test
    void 영_포함시_예외_발생() {
        // given
        List<String> input = List.of("1", "0", "3");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseNum(input));
    }

    @Test
    void 큰_정수_파싱() {
        // given
        List<String> input = List.of("1", "2147483647", "3");

        // when
        List<Integer> result = parser.parseNum(input);

        // then
        assertEquals(List.of(1, Integer.MAX_VALUE, 3), result);
    }

    @Test
    void 정수_범위_초과시_예외_발생() {
        // given
        List<String> input = List.of("1", "2147483648", "3");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> parser.parseNum(input));
    }
}
