package calculator;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorDelimiterTest {
    @Test
    void 커스텀_구분자는_맨_앞에_위치한다() {
        assertSimpleTest(() -> {
            // given
            final String input = "1;2;3//;\\n";

            assertThatThrownBy(() -> {
                // when
                new CalculatorDelimiter(input);
                // then
            }).isInstanceOf(InvalidInputException.class);
        });
    }

    @Test
    void 커스텀_구분자의_개행_미포함() {
        assertSimpleTest(() -> {
            // given
            final String input = "//;1;2;3";

            assertThatThrownBy(() -> {
                // when
                new CalculatorDelimiter(input);
                // then
            }).isInstanceOf(InvalidInputException.class);
        });
    }

    @Test
    void 커스텀_구분자의_슬래시_미포함() {
        assertSimpleTest(() -> {
            // given
            final String input = ";\\n1;2;3";

            assertThatThrownBy(() -> {
                // when
                new CalculatorDelimiter(input);
                // then
            }).isInstanceOf(InvalidInputException.class);
        });
    }

    @Test
    void 올바른_커스텀_구분자() {
        assertSimpleTest(() -> {
            // given
            final String input = "//;\\n1;2;3";

            // when
            final CalculatorDelimiter calculatorDelimiter = new CalculatorDelimiter(input);
            final String regex = calculatorDelimiter.getDelimiterRegex();

            // then
            assertThat(regex).contains(";");
        });
    }
}