package calculator.unit.validationRule;

import static calculator.util.Message.입력값이_비어있습니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.EmptyInputValidationRule;
import calculator.validationRule.ValidationRule;
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
    @DisplayName("실패 케이스")
    class FailureCases {
        @Test
        @DisplayName("빈 문자열 테스트")
        void emptyStringTest() {
            assertThatThrownBy(() -> rule.validate(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(입력값이_비어있습니다);
        }
    }
}