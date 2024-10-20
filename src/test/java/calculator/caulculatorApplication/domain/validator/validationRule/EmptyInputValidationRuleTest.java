package calculator.caulculatorApplication.domain.validator.validationRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import calculator.calculatorApplication.domain.validator.impl.ValidationRule;
import calculator.calculatorApplication.domain.validator.impl.validationRule.EmptyInputValidationRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class EmptyInputValidationRuleTest {
    private final ValidationRule rule = new EmptyInputValidationRule();


    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {
        @Test
        @DisplayName("유효 입력 테스트")
        void validInputTest() {
            assertThatNoException().isThrownBy(() -> rule.validate("valid input"));
        }
    }

    @Nested
    @DisplayName(" \"\" 빈값 넣었을 때 에러X ")
    class SuccessCases2 {
        @Test
        @DisplayName("유효 입력 테스트")
        void validInputTest() {
            assertThatNoException().isThrownBy(() -> rule.validate(""));
        }
    }


}