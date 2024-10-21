package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class StringHandlerTest {

    private final StringHandler stringHandler = new StringHandler();

    @Test
    void 기본_구분자로_문자열_파싱() {
        CalculationString calculationString = new CalculationString("1,2:3");
        int[] result = stringHandler.parseString(calculationString);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 커스텀_구분자로_문자열_파싱() {
        CalculationString calculationString = new CalculationString("//;\\n1;2;3");
        int[] result = stringHandler.parseString(calculationString);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 빈_문자열은_기본값_반환() {
        CalculationString calculationString = new CalculationString("");
        int[] result = stringHandler.parseString(calculationString);
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void 음수_입력_예외_테스트() {
        CalculationString calculationString = new CalculationString("1,-2,3");
        assertThatThrownBy(() -> stringHandler.parseString(calculationString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_커스텀_구분자_문법_예외_테스트() {
        CalculationString calculationString = new CalculationString("//;;\\n1;2");
        assertThatThrownBy(() -> stringHandler.parseString(calculationString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 여러_자리_숫자_파싱() {
        CalculationString calculationString = new CalculationString("100,200:300");
        int[] result = stringHandler.parseString(calculationString);
        assertArrayEquals(new int[]{100, 200, 300}, result);
    }
}
