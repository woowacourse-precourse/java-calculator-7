package calculator.unit.validationRule;

import static calculator.util.Message.입력값이_null입니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.NullInputValidationRule;
import calculator.validationRule.ValidationRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NullInputValidationRuleTest {

    private final ValidationRule rule = new NullInputValidationRule();

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {
        @Test
        @DisplayName("유효한 입력 테스트")
        void validInputTest() {
            assertThatNoException().isThrownBy(() -> rule.validate("valid input"));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {
        @Test
        @DisplayName("null 입력 테스트")
        void nullInputTest() {
            assertThatThrownBy(() -> rule.validate(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(입력값이_null입니다);
        }
    }
}