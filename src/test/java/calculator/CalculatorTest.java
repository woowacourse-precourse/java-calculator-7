package calculator;

import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("빈 리스트인 경우")
    void testIsEmptyList() {
        List<Integer> splitedNumber = new ArrayList<>();
        Calculator calculator = new Calculator(new InputView());
        int sum = calculator.numberSum(splitedNumber);

        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 있는 경우")
    void testIsExistList() {
        List<Integer> splitedNumber = Arrays.asList(1, 2, 3, 4);
        Calculator calculator = new Calculator(new InputView());
        int sum = calculator.numberSum(splitedNumber);

        assertThat(sum).isEqualTo(10);
    }

}