package calculator.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    @Test
    @DisplayName("읽고 분리하기")
    void test1() {
        String delimiterLine = "//;\\n";
        String numberLine = "1;2;3";
        Delimiter delimiter = new Delimiter(delimiterLine + numberLine);

        assertArrayEquals(delimiter.split(numberLine), new String[]{"1","2","3"});
    }
}