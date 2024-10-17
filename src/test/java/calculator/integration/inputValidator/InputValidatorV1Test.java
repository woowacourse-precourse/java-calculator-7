package calculator.integration.inputValidator;

import static calculator.util.Message.입력값이_null입니다;
import static calculator.util.Message.입력값이_비어있습니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.inputValidator.InputValidator;
import calculator.inputValidator.InputValidatorV1;
import calculator.validationRule.EmptyInputValidationRule;
import calculator.validationRule.NullInputValidationRule;
import calculator.validationRule.ValidationRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorV1Test {


    @Test
    @DisplayName("InputValidatorV1 동작 성공 테스트")
    void inputValidatorV1_Success() {
        String input = " input";
        List<ValidationRule> validationRules = List.of(new EmptyInputValidationRule(), new NullInputValidationRule());
        InputValidator inputValidator = new InputValidatorV1(validationRules);

        //then
        inputValidator.validate(input);

    }

    @Test
    @DisplayName("InputValidatorV1 null 입력 테스트")
    void inputValidatorV1_exception_null() {
        List<ValidationRule> validationRules = List.of(new EmptyInputValidationRule(), new NullInputValidationRule());
        InputValidator inputValidator = new InputValidatorV1(validationRules);

        // then
        assertThatThrownBy(() -> inputValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(입력값이_null입니다);
    }

    @Test
    @DisplayName("InputValidatorV1 빈 값 입력 테스트")
    void inputValidatorV1_exception_empty() {
        List<ValidationRule> validationRules = List.of(new EmptyInputValidationRule(), new NullInputValidationRule());
        InputValidator inputValidator = new InputValidatorV1(validationRules);

        // then
        assertThatThrownBy(() -> inputValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(입력값이_비어있습니다);

    }

}