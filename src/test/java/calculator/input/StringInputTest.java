package calculator.input;

import static calculator.input.StringInput.validateInput;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringInputTest {
    @Test
    @DisplayName("유효한 입력 테스트")
    void validInput() {
        String input1 = "//\n123";
        String input2 = "//test\n12test";

        String result1 = validateInput(input1);
        String result2 = validateInput(input2);
        assertEquals(input1, result1);
        assertEquals(input2, result2);
    }

    @Test
    @DisplayName("null 입력 테스트")
    void inputWithNull() {
        assertThrows(IllegalArgumentException.class, () -> validateInput(null));
    }

    @Test
    @DisplayName("빈 입력 테스트")
    void inputWithEmpty() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> validateInput(input));
    }

    @Test
    @DisplayName("'//'로 시작하지 않는 문자열 테스트")
    void startWithoutSlash() {
        String input = "test//";

        assertThrows(IllegalArgumentException.class, () -> validateInput(input));
    }

    @Test
    @DisplayName("'\\n'이 없는 문자열 테스트")
    void inputWithoutEndLine() {
        String input = "//test";

        assertThrows(IllegalArgumentException.class, () -> validateInput(input));
    }
}