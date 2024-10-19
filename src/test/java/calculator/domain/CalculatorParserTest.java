package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorParserTest {
    @Test
    void 기본_구분자로_피연산자를_분리한다() {
        // given & when
        final var calculatorParser = new CalculatorParser();
        List<Double> operands = calculatorParser.parse("1,2:3");

        // then
        assertThat(operands).isEqualTo(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)));
    }

    @Test
    void 커스텀_구분자로_피연산자를_분리한다() {
        // given & when
        final var calculatorParser = new CalculatorParser();
        List<Double> operands = calculatorParser.parse("//;\n1;2;3");

        // then
        assertThat(operands).isEqualTo(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)));
    }
}