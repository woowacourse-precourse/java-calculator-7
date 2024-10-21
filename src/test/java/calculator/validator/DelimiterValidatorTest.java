package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;

class DelimiterValidatorTest {

    @Test
    void 잘못된_구분자_포맷_예외_발생() {
        int prefixIndex = 0;
        int suffixIndex = -1;

        assertThatThrownBy(() -> DelimiterValidator.validateDelimiterFormat(prefixIndex, suffixIndex)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("'//'와 '\\n'이 모두 존재해야 합니다.");
    }

    @Test
    void 잘못된_구분자_순서_예외_발생() {
        int prefixIndex = 2;
        int suffixIndex = 1;

        assertThatThrownBy(() -> DelimiterValidator.validateDelimiterFormat(prefixIndex, suffixIndex)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("'//'는 '\\n'보다 앞에 위치해야 합니다.");
    }

    @Test
    void 빈_커스텀_구분자_예외_발생() {
        String customDelimiter = "";

        assertThatThrownBy(() -> DelimiterValidator.validateCustomDelimiter(customDelimiter)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("커스텀 구분자가 비어 있습니다.");
    }

    @Test
    void 문자_1개로_구성되지_않은_커스텀_구분자_예외_발생() {
        String customDelimiter = "*&";

        assertThatThrownBy(() -> DelimiterValidator.validateCustomDelimiter(customDelimiter)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("커스텀 구분자는 문자 1개로 구성되어야 합니다.");
    }

    @Test
    void 숫자_커스텀_구분자_예외_발생() {
        String customDelimiter = "1";

        assertThatThrownBy(() -> DelimiterValidator.validateCustomDelimiter(customDelimiter)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("커스텀 구분자는 숫자가 될 수 없습니다.");
    }

    @Test
    void 기본_구분자를_커스텀_구분자로_설정_시_예외_발생() {
        String customDelimiter = ",";

        assertThatThrownBy(() -> DelimiterValidator.validateCustomDelimiter(customDelimiter)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("커스텀 구분자는 기본 구분자(, 또는 :)로 설정할 수 없습니다.");
    }

    @Test
    void 유효한_커스텀_구분자_성공() {
        String validCustomDelimiter = "#";

        assertThatCode(
                () -> DelimiterValidator.validateCustomDelimiter(validCustomDelimiter)).doesNotThrowAnyException();
    }
}