package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private final StringCalculator sc = new StringCalculator();

    @Test
    void 빈_문자열_테스트() {
        String input = "";
        int sum = sc.calculateSum(input);
        assertEquals(0, sum);
    }

    @Test
    void 기본_구분자와_양수로_구성된_문자열_테스트() {
        String input = "1,2:3";
        int sum = sc.calculateSum(input);
        assertEquals(6, sum);
    }

    @Test
    void 커스텀_구분자와_양수로_구성된_문자열_테스트() {
        String input = "//+\\n2+2+2+2";
        int sum = sc.calculateSum(input);
        assertEquals(8, sum);
    }

    @Test
    void 커스텀_구분자가_숫자인_문자열_테스트() {
        String input = "//2\\n123";
        int sum = sc.calculateSum(input);
        assertEquals(4, sum);
    }

    @Test
    void 커스텀_구분자와_음수가_포함된_문자열_테스트() {
        String input = "//;\\n1;-2;3";
        assertThatThrownBy(() -> sc.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_문자가_포함된_문자열_테스트() {
        String input = "가,1";
        assertThatThrownBy(() -> sc.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자가_올바르게_지정되지_않은_문자열_테스트() {
        String input = "!\\n1!2";
        assertThatThrownBy(() -> sc.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
