package calculator.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력값이 공백으로 시작했을 경우")
    @Test
    public void validateStartBlankTest() {
        //given
        String input = " 1,2,3,4";

        //then
        assertThatThrownBy(() -> InputValidator.validateStartBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 형식에서 '\\n'이 없을 경우 예외를 발생")
    @Test
    public void validateCustomSecondTest() {
        //given
        String input = "//%1%2%3%4";

        //then
        assertThatThrownBy(() -> InputValidator.validateCustomSecond(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}