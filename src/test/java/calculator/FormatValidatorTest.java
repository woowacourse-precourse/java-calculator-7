package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FormatValidatorTest {

    private final FormatValidator formatValidator = new FormatValidator();

    @Test
    void 수식이_비어있을_경우_예외가_발생하지_않는다() {
        // given
        String emptyFormula = "";

        // when, then
        assertDoesNotThrow(() -> formatValidator.validateFormula(emptyFormula));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2:3", "1&2*3", "1,2#3"})
    void 숫자로_시작하는_수식일_경우_기본_구분자_외의_문자가_존재하면_예외가_발생한다(String formula) {
        assertThatThrownBy(() -> formatValidator.validateFormula(formula))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("수식에는 기본 구분자(쉼표, 콜론)외의 문자가 포함될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//*\\n1*2^3", "//*\\n1&2%3", "//*\\n1,2#3"})
    void 커스텀_구분자_수식일_경우_구분자_외의_문자가_존재하면_예외가_발생한다(String formula) {
        assertThatThrownBy(() -> formatValidator.validateFormula(formula))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("올바른 커스텀 구분자 형식은 //<숫자가 아닌 문자>\\n입니다. "
                + "혹은 구분자 외의 문자가 포함되었는지 확인해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-", "/", "@"})
    void 비정상적인_수식일_경우_구분자_외의_문자가_존재하면_예외가_발생한다(String formula) {
        assertThatThrownBy(() -> formatValidator.validateFormula(formula))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("잘못된 수식입니다. 수식을 다시 한번 확인해 주세요.");
    }


}
