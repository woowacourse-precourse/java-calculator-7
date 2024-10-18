package calculator.integration.inputValidator;

import static calculator.util.Message.입력값이_null입니다;
import static calculator.util.Message.입력값이_비어있습니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.BasicFormatValidationRule;
import calculator.validationRule.CompositeValidationRule;
import calculator.validationRule.CustomTokenFormatValidationRule;
import calculator.validationRule.EmptyInputValidationRule;
import calculator.validationRule.NullInputValidationRule;
import calculator.validationRule.ValidationRule;
import calculator.validator.StringCalculatorValidator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringCalculatorValidatorTest {


    private StringCalculatorValidator stringCalculatorValidator;

    @BeforeEach
    void setUp() {

        List<ValidationRule> rules = Arrays.asList(
                new NullInputValidationRule(),
                new EmptyInputValidationRule(),
                new BasicFormatValidationRule(),
                new CustomTokenFormatValidationRule()
        );

        stringCalculatorValidator = new StringCalculatorValidator(new CompositeValidationRule(rules));
    }


    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {
        @Test
        @DisplayName("StringCalculatorValidator 동작 성공 테스트")
        void inputValidatorV1_Success() {
            String input = "1,2,3";

            //then
            stringCalculatorValidator.validate(input);

        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailCases {
        @Test
        @DisplayName("StringCalculatorValidator null 입력 테스트")
        void inputValidatorV1_exception_null() {
            // then
            assertThatThrownBy(() -> stringCalculatorValidator.validate(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(입력값이_null입니다);
        }

        @Test
        @DisplayName("StringCalculatorValidator 빈 값 입력 테스트")
        void inputValidatorV1_exception_empty() {

            // then
            assertThatThrownBy(() -> stringCalculatorValidator.validate(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(입력값이_비어있습니다);

        }
    }
}