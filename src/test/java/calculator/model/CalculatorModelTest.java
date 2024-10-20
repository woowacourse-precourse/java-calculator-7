package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorModelTest {

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1,2;3", "//\\n1,2,3,4"})
    void 커스텀_구분자_지정_문자_올바른_사용(String input) {
        CalculatorModel cm = new CalculatorModel();
        Assertions.assertThat(cm.CustomDiscrimination(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;1,2:3", ";\\n1,2,3;4"})
    void 커스텀_구분자_지정_문자_사용_예외(String input) {
        CalculatorModel cm = new CalculatorModel();
        assertThatThrownBy(() -> cm.CustomDiscrimination(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "n1,2;3", " 1,2,3,4"})
    void 커스텀_구분자_지정_X(String input) {
        CalculatorModel cm = new CalculatorModel();
        Assertions.assertThat(cm.CustomDiscrimination(input)).isEqualTo(false);
    }


}