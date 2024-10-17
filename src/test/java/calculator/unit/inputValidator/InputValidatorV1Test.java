package calculator.unit.inputValidator;

import calculator.inputValidator.InputValidator;
import calculator.inputValidator.InputValidatorV1;
import calculator.mock.FakeNullInputValidationRule;
import calculator.validationRule.ValidationRule;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorV1Test {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        List<ValidationRule> validationRules = List.of(
                new FakeNullInputValidationRule(),
                new FakeNullInputValidationRule()
        );
        inputValidator = new InputValidatorV1(validationRules);
    }

    @Test
    @DisplayName("InputValidatorV1 동작 성공 테스트")
    void inputValidatorV1_Success() {
        String input = " input";

        //then
        inputValidator.validate(input);

    }

}