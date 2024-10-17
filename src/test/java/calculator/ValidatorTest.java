package calculator;

import calculator.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    @DisplayName("null 입력 시 예외를 발생시킨다.")
    void null_입력_예외_발생() {
        assertThatThrownBy(() -> Validator.validateInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null입니다.");
    }

    @Test
    @DisplayName("올바르지 않은 형식의 커스텀 구분자 사용 시 예외를 발생시킨다.")
    void 잘못된_형식의_커스텀_구분자_예외_발생() {
        assertThatThrownBy(() -> Validator.validateDelimiter("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자에 숫자가 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("구분자 사이에 숫자가 없는 경우 예외를 발생시킨다.")
    void 구분자_사이에_숫자_없음_예외_발생() {
        assertThatThrownBy(() -> Validator.validateTokens(new String[]{"1", "", "2"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 사이에 숫자가 없습니다.");
    }
}
