package calculator.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력값이 공백으로 시작했을 경우")
    @Test
    public void validateStartBlankTest() {
        //given
        String input = " 1,2,3,4";

        //then
        Assertions.assertThatThrownBy(() -> InputValidator.validateStartBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}