package calculator.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputTest {

    private final InputHandler inputHandler = InputHandler.getInstance();

    @Test
    @DisplayName("사용자 입력을 정상적으로 받는지 테스트")
    void testGetInput() {
        // Given
        String simulatedInput = "1,2,3";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // When & Then
        assertDoesNotThrow(inputHandler::getInput);
    }

    @Test
    @DisplayName("입력 스트림을 정상적으로 닫는지 테스트")
    void testCloseInput() {
        // Given & When & Then
        assertDoesNotThrow(inputHandler::closeInput);
    }
}
