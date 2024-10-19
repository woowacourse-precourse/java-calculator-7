package calculator.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringParserTest {

    private StringParser stringParser = new StringParser();

    @Test
    void 공백문자_입력시_0을_포함한_리스트_반환() {
        List<Integer> result = stringParser.extractNumbers("");
        assertEquals(List.of(0), result);
    }

    @Test
    void 정수_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("1,2:3");
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void 커스텀_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("//;\\n1;2;3");
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void 혼합_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("//;\\n1,2:3;4");
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    @Test
    void 유효하지_않은_숫자_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractNumbers("1,2,a");
        });
    }

    @Test
    void 음수_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("-1,2,-3");
        assertEquals(List.of(-1, 2, -3), result);
    }

    @Test
    void 큰_숫자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("1000,2000,3000");
        assertEquals(List.of(1000, 2000, 3000), result);
    }

    @Test
    void 여러_자리_커스텀_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("//*%*\\n1*%*2*%*3");
        assertEquals(List.of(1, 2, 3), result);
    }
}
