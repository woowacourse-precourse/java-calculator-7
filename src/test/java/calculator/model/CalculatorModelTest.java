package calculator.model;

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

}