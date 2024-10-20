package calculator.parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DelimiterParserTest {
    private final DelimiterParser delimiterParser = new DelimiterParser();

    @Test
    void 기본_구문자_테스트() {
        // 기본 구분자 ","와 ":"가 포함된 경우
        String input = "1,2:3";
        String[] result = delimiterParser.parseDelimiters(input);

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 커스텀_구문자_테스트() {
        // 커스텀 구분자 "//;\n"가 포함된 경우
        String input = "//;\\n1;2;3";
        String[] result = delimiterParser.parseDelimiters(input);

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 커스텀_구문자_테스트2() {
        //여러개의 특수 문자를 구분자로 사용하는 커스텀 구분자
        String input = "//***\\n1***2***3";
        String[] result = delimiterParser.parseDelimiters(input);

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

}
