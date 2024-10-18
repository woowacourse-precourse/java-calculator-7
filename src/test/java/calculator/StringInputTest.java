package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringInputTest {
    @DisplayName("입력값 빈값 null값 아닌지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈공백문자_혹은_null일경우_에러(String input) {
        assertThatThrownBy(() -> {
            new StringInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
