package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class DelimiterTest {
    @Test
    void 기본_구분자를_사용하여_문자열을_분리한다() {
        Delimiter delimiter = new Delimiter("1,2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, delimiter.getDelimitedNumbers());
    }

    @Test
    void 커스텀_구분자를_사용하여_문자열을_분리한다() {
        Delimiter delimiter = new Delimiter("//;\\n1;2;3");
        assertArrayEquals(new String[]{"1", "2", "3"}, delimiter.getDelimitedNumbers());
    }
}