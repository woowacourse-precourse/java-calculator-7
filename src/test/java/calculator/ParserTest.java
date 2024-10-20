package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    void 커스텀_구분자가_없을_때_테스트() {
        String input = "1";
        List<Double> expected = List.of(1.0);
        List<Double> result = parser.parseInput(input);

        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자가_1개_있을_때_테스트() {
        String input = "//;\\n1;2;3";
        List<Double> expected = List.of(1.0, 2.0, 3.0);
        List<Double> result = parser.parseInput(input);

        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자가_설정_영역은_있지만_커스텀_구분자가_없는_경우_성공_테스트() {
        String input = "//\\n1,2:3";
        List<Double> expected = List.of(1.0, 2.0, 3.0);
        List<Double> result = parser.parseInput(input);

        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_설정_포멧이_여러개인_경우_실패_테스트() {
        String input = "//;\n//;\n1,2:3";
        assertThrows(IllegalArgumentException.class,
                () -> {
            parser.parseInput(input);
        });
    }
}
