package refactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); //테스트 메서드마다 실행 전 초기화
    }

    @Test
    void 빈_문자열을_입력하면_0을_반환한다() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void 음수나_0이_있는_경우_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.add("-1,2,3,10"));
        assertThrows(IllegalArgumentException.class, () ->
                calculator.add("0,2,3,10"));
    }

    @Test
    void 기본_구분자_더하기_테스트() {
        assertEquals(13, calculator.add("1:2,10"));
    }

    @Test
    void 커스텀_구분자_더하기_테스트() {
        assertEquals(13, calculator.add("//;\\n1;2,10"));
        assertEquals(1, calculator.add("//;\\n1"));

    }
}
