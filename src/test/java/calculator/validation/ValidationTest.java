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
}
