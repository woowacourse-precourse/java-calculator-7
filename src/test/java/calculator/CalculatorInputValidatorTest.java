package calculator;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorInputValidatorTest {
    private final CalculatorInputValidator calculatorInputValidator = new CalculatorInputValidator();

    @Test
    void 커스텀_구분자는_맨_앞에_위치한다() {
        assertSimpleTest(() -> {
            // given
            String input = "1;2;3//;\\n";

            assertThatThrownBy(() -> {
                // when
                calculatorInputValidator.validate(input);
                // then
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자의_개행_미포함() {
        assertSimpleTest(() -> {
            // given
            String input = "//;1;2;3";

            assertThatThrownBy(() -> {
                // when
                calculatorInputValidator.validate(input);
                // then
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자의_슬래시_미포함() {
        assertSimpleTest(() -> {
            // given
            String input = ";\\n1;2;3";

            assertThatThrownBy(() -> {
                // when
                calculatorInputValidator.validate(input);
                // then
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}