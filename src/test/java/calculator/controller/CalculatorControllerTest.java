package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {
    private final CalculatorController controller = CalculatorController.getInstance();

    @Test
    @DisplayName("입력된 숫자에 맞게 정확하게 계산한다.")
    public void calculateTest() {
        // GIVEN
        String input = "1,2,3,4,5";
        Long answer = 15L;

        // WHEN
        Long calculated = controller.calculateNumbers(input);

        // THEN
        assertThat(calculated).isEqualTo(answer);
    }

    @Test
    @DisplayName("잘못된 값이 왔을 때 `IllegalArgumentException`을 발생시킨다.")
    public void throwExceptionTest() {
        // GIVEN
        String input = "1a2,3,4,5";

        // WHEN - THEN
        assertThrows(IllegalArgumentException.class, () -> controller.calculateNumbers(input));
    }
}
