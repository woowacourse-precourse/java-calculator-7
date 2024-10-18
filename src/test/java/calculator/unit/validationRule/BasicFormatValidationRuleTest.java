package calculator.unit.validationRule;

import static calculator.util.Message.잘못된_기본_입력_형식입니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.BasicFormatValidationRule;
import calculator.validationRule.ValidationRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BasicFormatValidationRuleTest {
    private final ValidationRule rule = new BasicFormatValidationRule();

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "10,20,30", "1", "1234"})
        @DisplayName("유효한 기본 입력 형식 테스트")
        void validBasicFormatInputTest(String input) {
            assertThatNoException().isThrownBy(() -> rule.validate(input));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,", "1:2:-3", "1,2,a", "1..2", "1,2;", ",1,2,3", "1,2,3:", "1,2,,3", "1::2"})
        @DisplayName("잘못된 기본 입력 형식 테스트")
        void invalidBasicFormatInputTest(String input) {
            assertThatThrownBy(() -> rule.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(잘못된_기본_입력_형식입니다);
        }
    }

}