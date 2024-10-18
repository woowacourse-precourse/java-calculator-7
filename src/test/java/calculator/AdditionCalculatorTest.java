package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Model.AdditionCalculator;
import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionCalculatorTest {
    AdditionCalculator adder = new AdditionCalculator();

    @Test
    void 덧셈_테스트() {
        assertSimpleTest(() -> assertThat(adder.add(new int[]{1, 2, 3})).isEqualTo(6));
    }

    @Test
    void 덧셈_테스트_빈_리스트() {
        Assertions.assertSimpleTest(() -> assertThat(adder.add(new int[]{})).isEqualTo(0));
    }

}
