package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @DisplayName("null 입력 시 0 반환")
    @Test
    void nullInputTest() {
        String result = inputHandler.processInput(null);
        assertThat(result).isEqualTo("0");
    }

    @DisplayName("빈 문자열 입력 시 0 반환")
    @Test
    void emptyInputTest() {
        String result = inputHandler.processInput("");
        assertThat(result).isEqualTo("0");
    }

    @DisplayName("공백 문자열 입력 시 0 반환")
    @Test
    void blankInputTest() {
        String result = inputHandler.processInput("   ");
        assertThat(result).isEqualTo("0");
    }

    @DisplayName("앞뒤 공백이 있는 문자열 입력 시 공백 제거된 문자열 반환")
    @Test
    void trimmedInputTest() {
        String result = inputHandler.processInput(" 123 ");
        assertThat(result).isEqualTo("123");
    }

    @DisplayName("정상적인 문자열 입력 시 그대로 반환")
    @Test
    void validInputTest() {
        String result = inputHandler.processInput("456");
        assertThat(result).isEqualTo("456");
    }
}