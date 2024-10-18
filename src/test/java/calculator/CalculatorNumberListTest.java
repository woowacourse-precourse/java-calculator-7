package calculator;

import calculator.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorNumberListTest {

    @Test
    void 음수는_사용할_수_없다() {
        assertSimpleTest(() -> {
            // given
            List<Integer> input = new ArrayList<>(){{
                add(-1);
                add(2);
                add(3);
            }};

            // when, then
            assertThatThrownBy(() -> {
                new CalculatorNumberList(input);
            }).isInstanceOf(InvalidNumberException.class);
        });
    }

    @Test
    void 양의_정수를_더할_수_있다() {
        assertSimpleTest(() -> {
            // given
            List<Integer> input = new ArrayList<>(){{
                add(1);
                add(2);
                add(3);
            }};
            CalculatorNumberList calculatorNumberList = new CalculatorNumberList(input);

            // when
            assertThat(calculatorNumberList.sum()).isEqualTo(1+2+3);
        });
    }
}