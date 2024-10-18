package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class DelimiterParserTest {
    DelimiterParser parser = new DelimiterParser();

    @Test
    void 기본_구분자_테스트() {
        //given
        String input = "1,2:3";

        //when
        String[] result = parser.splitNumbers(input);

        //then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 커스텀_구분자_테스트() {
        //given
        String input = "//;\\n1;2;3";

        //when
        String[] result = parser.splitNumbers(input);

        //then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 기본_커스텀_구분자_혼합_테스트() {
        //given
        String input = "//;\\n1;2,3:4;5";

        //when
        String[] result = parser.splitNumbers(input);

        //then
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, result);
    }

}