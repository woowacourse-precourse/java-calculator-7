package calculator.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.constants.InvalidInputConstants;
import calculator.domain.input.Input;
import calculator.domain.input.InputTypeSorter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "//;\\n1;2;-3", "-1"})
    void 음수_포함(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(InputTypeSorter.sort(input)::createCalculationInputs)
                .withMessageMatching(InvalidInputConstants.CONTAINS_NEGATIVE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3", "//;\\n1;2.3"})
    void 잘못된_구분자_포함(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(InputTypeSorter.sort(input)::createCalculationInputs)
                .withMessageMatching(InvalidInputConstants.WRONG_DELIMITER);
    }

    @Test
    void 커스텀_구분자_없음() {
        Input customInput = InputTypeSorter.sort("//\\n1;2;3");

        assertThatIllegalArgumentException()
                .isThrownBy(customInput::createCalculationInputs)
                .withMessageMatching(InvalidInputConstants.INVALID_CUSTOM_FORMAT);
    }

}
