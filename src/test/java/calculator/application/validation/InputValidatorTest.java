package calculator.application.validation;

import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.application.dto.request.CalculationRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 테스트")
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 입력_값이_비어있을때_예외를_발생() {
        // given
        String input = "";
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_EMPTY.getMessage());
    }

    @Test
    void 입력_값이_앞뒤로_공백이_있을때_예외를_발생() {
        // given
        String input = " 1,2,3 ";
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_NOT_TRIMMED.getMessage());
    }

    @Test
    void 입력_값이_숫자로_끝나지_않을때_예외를_발생() {
        // given
        String input = "1,2,3,";
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_NOT_ENDED_WITH_NUMBER.getMessage());
    }

    @Test
    void 입력_값에_제대로_된_커스텀_구분자_Prefix_값이_없을때_예외를_발생() {
        // given
        String input = ";\\n1;2;3";
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
    }

    @Test
    void 입력_값에_제대로_된_커스텀_구분자_Suffix_값이_없을때_예외를_발생() {
        // given
        String input = "//1;2;3";
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
    }

    @Test
    void 입력_값에_제대로_된_커스텀_구분자_Suffix_값이_아닐때_예외를_발생() {
        // given
        String input = "//;\\1,2,3";
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatThrownBy(() -> inputValidator.validate(calculationRequest))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"//@\\n1@2@3", "//*\\n1*2*3", "1,2:3"})
    void 제대로된_입력값이_주어졌을때_예외가_발생하지_않는다(String input) {
        // given
        CalculationRequest calculationRequest = new CalculationRequest(input);

        // when & then
        Assertions.assertThatCode(() -> inputValidator.validate(calculationRequest))
            .doesNotThrowAnyException();
    }
}