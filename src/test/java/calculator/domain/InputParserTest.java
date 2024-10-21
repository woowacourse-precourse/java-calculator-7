package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {
    @Test
    void 기본_구분자로_피연산자를_분리한다() {
        // given & when
        final var inputParser = new InputParser(new Delimiters());
        List<Double> operands = inputParser.parse("1,2:3");

        // then
        assertThat(operands).isEqualTo(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)));
    }

    @Test
    void 커스텀_구분자로_피연산자를_분리한다() {
        // given & when
        final var calculatorParser = new InputParser(new Delimiters());
        List<Double> operands = calculatorParser.parse("//;\\n1;2;3");

        // then
        assertThat(operands).isEqualTo(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)));
    }

    @Test
    void 구분자로_구분된_값이_양수인지_검증한다_숫자가_아닌_경우(){
        // given
        final var calculatorParser = new InputParser(new Delimiters());

        // when & then
        assertThatThrownBy(() -> calculatorParser.parse("//;\\n1;aaaa;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피연산자가 숫자가 아닙니다.");
    }

    @Test
    void 구분자로_구분된_값이_양수인지_검증한다_음수인_경우(){
        // given
        final var calculatorParser = new InputParser(new Delimiters());

        // when & then
        assertThatThrownBy(() -> calculatorParser.parse("//;\\n1;-2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피연산자가 양수가 아닙니다.");
    }

}