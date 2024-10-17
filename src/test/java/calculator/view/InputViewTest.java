package calculator.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("validate user input")
    void testValidInput() {
        // given
        String validInput = "1,2";

        // when & then
        inputView.validateUserInput(validInput);
    }

    @Test
    @DisplayName("빈 문자열 입력 시 validateInput 메서드 예외 발생")
    void testEmptyInput() {
        // given
        String validInput = "";

        // when & then
        assertThatThrownBy(() -> {
            inputView.validateUserInput(validInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("null 입력 시 validateInput 메서드 예외 발생")
    void testNullInput() {
        // given
        String nullInput = null;

        // when & then
        assertThatThrownBy(() -> {
            inputView.validateUserInput(nullInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("공백 문자열 입력 시 validateInput 메서드 예외 발생")
    void testWhitespaceInput() {
        // given
        String whitespaceInput = "  ";

        // when & then
        assertThatThrownBy(() -> {
            inputView.validateUserInput(whitespaceInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다.");

    }

}
