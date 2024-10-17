package calculator.unit.validationRule;

import static calculator.util.Message.입력값이_null입니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.NullInputValidationRule;
import calculator.validationRule.ValidationRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NullInputValidationRuleTest {

    @Test
    @DisplayName("NullInputValidationRule null 입력 테스트")
    void nullInputTest() {
        ValidationRule validationRule = new NullInputValidationRule();
        assertThatThrownBy(() -> validationRule.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(입력값이_null입니다);
    }

    @Test
    @DisplayName("NullInputValidationRule 유효한 입력 테스트")
    void validInputTest() {
        ValidationRule validationRule = new NullInputValidationRule();
        assertThatCode(() -> validationRule.validate("valid input"))
                .doesNotThrowAnyException();
    }

}