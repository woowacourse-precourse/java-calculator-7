package calculator.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    @DisplayName("null 입력 시 예외를 던진다")
    void throwsExceptionForNullInput() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInput(null));
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외를 던진다")
    void throwsExceptionForEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInput(""));
    }
}
