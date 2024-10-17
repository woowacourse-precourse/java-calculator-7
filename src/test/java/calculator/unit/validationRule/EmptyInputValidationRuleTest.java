package calculator.unit.validationRule;

import static calculator.util.Message.입력값이_비어있습니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.EmptyInputValidationRule;
import calculator.validationRule.ValidationRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmptyInputValidationRuleTest {


    @Test
    @DisplayName("EmptyInputValidationRule 빈 문자열 테스트")
    void emptyStringTest() {
        ValidationRule validationRule = new EmptyInputValidationRule();
        assertThatThrownBy(() -> validationRule.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(입력값이_비어있습니다);
    }


    @Test
    @DisplayName("EmptyInputValidationRule 유효한 입력 테스트")
    void validInputTest() {
        ValidationRule validationRule = new EmptyInputValidationRule();
        assertThatCode(() -> validationRule.validate("valid input"))
                .doesNotThrowAnyException();
    }

}