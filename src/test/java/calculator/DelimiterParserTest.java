package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DelimiterParserTest {

    @Test
    void 커스텀_구분자가_없는_경우_문자_분리() {
        String mockInput = "1,2:3";
        String[] result = {"1", "2", "3"};

        var delimiterParser = new DelimiterParser();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);

        assertArrayEquals(result, splitResults);
    }

    @Test
    void 커스텀_구분자가_있는_경우_문자_분리() {
        String mockInput = "//a\\n1a2a3:4";
        String[] result = {"1", "2", "3", "4"};

        var delimiterParser = new DelimiterParser();
        String[] splitResults = delimiterParser.splitByDelimiter(mockInput);

        assertArrayEquals(result, splitResults);
    }
}

