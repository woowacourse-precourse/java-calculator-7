package calculator.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {

    private CalculatorController controller = new CalculatorController();

    @Test
    public void 입력_형식_예외_테스트() {
        // given
        String input = "s,1,2";

        // when & then
        Assertions.assertThatThrownBy(() -> controller.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 숫자 또는 //로 시작해야 합니다.");
    }
}
