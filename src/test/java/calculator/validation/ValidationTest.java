package calculator.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    @DisplayName("문자열에 숫자가 아닌 문자가 있는 경우 예외발생")
    void validateNumericString() {
        assertThatThrownBy(() -> Validation.validateNumberFormat("1,2,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("int의 범위를 넘는 경우 예외발생")
    void throwExceptionWhenNumberExceedIntRange() {
        assertThatThrownBy(() -> Validation.validateIntRange("10000000000,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수를 입력한 경우 예외발생")
    void throwExceptionWhenNumberIsNegative() {
        assertThatThrownBy(() -> Validation.validateNegativeNumber("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자에 백슬래시를 포함하는 경우 예외발생")
    void throwExceptionWhenDelimiterContainsBackSlash() {
        assertThatThrownBy(() -> Validation.validateNegativeNumber("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
