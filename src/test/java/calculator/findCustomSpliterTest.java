package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FindCustomSpliterTest {

    @Test
    void testCustomSplitterWithValidDelimiter() {
        findCustomSpliter splitter = new findCustomSpliter();
        String input = "//;\n1;2;3";
        String expected = ";";
        assertEquals(expected, splitter.customSpliter(input));
    }

    @Test
    void testCustomSplitterWithDifferentDelimiter() {
        findCustomSpliter splitter = new findCustomSpliter();
        String input = "//,\n4,5,6";
        String expected = ",";
        assertEquals(expected, splitter.customSpliter(input));
    }

    @Test
    void testCustomSplitterWithoutDelimiter() {
        findCustomSpliter splitter = new findCustomSpliter();
        String input = "1,2,3";
        String expected = "";
        assertEquals(expected, splitter.customSpliter(input));
    }

    @Test
    void testCustomSplitterWithInvalidFormat() {
        findCustomSpliter splitter = new findCustomSpliter();
        String input = "//;1;2;3"; // 잘못된 형식 (필요한 '\n'이 없음)
        assertThrows(IllegalArgumentException.class, () -> {
            splitter.customSpliter(input); // 예외 발생 여부 확인
        });
    }
}
