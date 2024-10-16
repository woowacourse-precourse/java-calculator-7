package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicDelimiterTest {

    private BasicDelimiter basicDelimiter;

    @BeforeEach
    public void setUp(){
        basicDelimiter = new BasicDelimiter();
    }

    @Test
    public void 콤마_분할(){
        String input = "1,2,3";
        String[] result = basicDelimiter.split(input);
        assertArrayEquals(new String[] {"1", "2", "3"}, result);
    }

    @Test
    public void 콤마_콜론_분할(){
        String input = "1,2:3";
        String[] result = basicDelimiter.split(input);
        assertArrayEquals(new String[] {"1", "2", "3"}, result);
    }

    @Test
    public void 구분자_사이_빈문자열(){
        String input = "1::2";
        String[] result = basicDelimiter.split(input);
        assertArrayEquals(new String[] {"1", "", "2"}, result);
    }
}