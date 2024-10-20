package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SeparatorTest {
    private Separator separator = new Separator();

    @Test
    void 커스텀_구분자_추가() {
        separator.checkCustomSeparator("//n\\n");
        List<Character> expected = List.of(':', ',', 'n');
        assertEquals(separator.getSeparatorList(), expected);
    }

    @Test
    void 커스텀_구분자_없음() {
        separator.checkCustomSeparator("12345");
        List<Character> expected = List.of(':', ',');
        assertEquals(separator.getSeparatorList(), expected);
    }
}