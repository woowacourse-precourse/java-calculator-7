package vaildation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vaildation.InputValidation.CheckInput;


import org.junit.jupiter.api.Test;

public class InputValidationTest {

    @Test
    void UseCustomSeparatorError1() {
        InputValidationException("//;\\n1//;\\n", ";");
    }

    @Test
    void UseNegativeNumberError() {
        InputValidationException("-1,2,3", ",");
    }

    private void InputValidationException(String input, String delimiter) {
        assertThatThrownBy(() -> CheckInput(input, delimiter))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
