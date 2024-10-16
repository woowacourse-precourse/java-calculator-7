package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperandTest {

    @DisplayName("문자열 입력 실패 : 숫자가 아닌 문자열 입력")
    @ParameterizedTest
    @ValueSource(strings = {"abc,2:3", "!@,2:3"})
    void parseToIntTest(String inputs) {
        // given

        // when, then
        assertThatThrownBy(() -> new Calculator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자열이 입력되었습니다.");
    }

    @DisplayName("문자열 입력 실패 : 양수가 아닌 수 입력")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2:3", "0,2:3"})
    void validatePositiveTest(String inputs) {
        // given

        // when, then
        assertThatThrownBy(() -> new Calculator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 숫자가 양수가 아닙니다.");
    }
}
