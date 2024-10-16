package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {

    InputManager inputManager = new InputManager();

    @Test
    @DisplayName("isInteger 기능 테스트")
    void isInteger_test() {
        assertTrue(inputManager.isInteger("3"));
        assertFalse(inputManager.isInteger("z"));
    }

}