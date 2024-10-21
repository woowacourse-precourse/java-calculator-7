package calculator.util;

import calculator.domain.CalcTarget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("구분자 뒤에 숫자가 없는 값에 대한 검증")
    void validNoNumBehindSeparator() {
        // given
        String input = "1,2,3,";
        CalcTarget calcTarget = CalcTarget.input(input);
        // when&then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(calcTarget));
    }

    @Test
    @DisplayName("커스텀 구분자뒤에 숫자가 없는 값에 대한 검증")
    void validNoNumBehindCustomSeparator() {
        // given
        String input = "//;\\n1;2,3;";
        CalcTarget calcTarget = CalcTarget.input(input);
        // when&then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(calcTarget));
    }
}