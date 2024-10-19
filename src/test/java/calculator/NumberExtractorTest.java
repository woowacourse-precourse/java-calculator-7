package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NumberExtractorTest {
    @Test
    void 기본_구분자를_사용하여_문자열을_분리한다() {
        NumberExtractor numberExtractor = new NumberExtractor("1,2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, numberExtractor.extractDelimitedNumbers());
    }

    @Test
    void 커스텀_구분자를_사용하여_문자열을_분리한다() {
        NumberExtractor numberExtractor = new NumberExtractor("//;\\n1;2;3");
        assertArrayEquals(new String[]{"1", "2", "3"}, numberExtractor.extractDelimitedNumbers());
    }
}