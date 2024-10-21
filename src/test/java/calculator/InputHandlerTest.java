package calculator;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputHandlerTest {

    @Test
    void givenEmptyString_whenCalculateSumFromInput_thenThrowException() {
        InputHandler inputHandler = new InputHandler();

        // 빈 문자열이 입력되면 IllegalArgumentException이 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateInput("");  // 빈 문자열 테스트
        });
    }

    @Test
    void givenWhitespaceOnly_whenValidateInput_thenThrowException() {
        InputHandler inputHandler = new InputHandler();
        assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateInput("   ");  // 공백만 있는 입력 테스트
        });
    }

    @Test
    void givenEmptyCustomDelimiter_whenValidateCustomDelimiter_thenThrowException() {
        InputHandler inputHandler = new InputHandler();

        // 빈 커스텀 구분자가 입력되면 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateInput("//\\n");
        });
    }

    @Test
    void givenInvalidDelimiter_whenValidateInput_thenThrowException() {
        InputHandler inputHandler = new InputHandler();

        // 구분자가 , 또는 : 이외의 문자가 포함되면 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateInput("1,2:3;");  // 잘못된 구분자 ';' 사용
        });
    }

    @Test
    void givenValidDelimiter_whenValidateInput_thenNoException() {
        InputHandler inputHandler = new InputHandler();

        // 콤마와 콜론만 포함된 정상 입력
        assertDoesNotThrow(() -> {
            inputHandler.validateInput("1,2:3");
        });
    }

    @Test
    void givenCustomDelimiter_whenValidateInput_thenNoException() {
        InputHandler inputHandler = new InputHandler();

        // 커스텀 구분자 ; 이 지정된 경우, 콤마, 콜론과 함께 정상 처리되어야 함
        assertDoesNotThrow(() -> {
            inputHandler.validateInput("//;\\n1;2;3;");
        });
    }

    @Test
    void givenInvalidCharacter_whenValidateInput_thenThrowException() {
        InputHandler inputHandler = new InputHandler();

        // 잘못된 구분자가 포함된 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateInput("//;\\n1,2:3/");
        });
    }

    @Test
    void givenNumericCustomDelimiter_whenValidateInput_thenThrowException() {
        InputHandler inputHandler = new InputHandler();
        
        // 커스텀 구분자로 숫자가 들어왔을 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.validateInput("//1\n1,2:3");
        });
    }
}
