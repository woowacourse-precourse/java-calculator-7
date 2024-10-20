package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 주어진_구분자를_활용해_덧셈한다() {
        ExpressionParser parser = new ExpressionParser(List.of(","));
        Calculator calculator = new Calculator(parser);
        int result = calculator.calculateSum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수가_포함된_경우_예외를_발생한다() {
        ExpressionParser parser = new ExpressionParser(List.of(","));
        Calculator calculator = new Calculator(parser);
        assertThatThrownBy(() -> calculator.calculateSum("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}
