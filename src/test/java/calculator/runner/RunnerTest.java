package calculator.runner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RunnerTest {

    @Test
    @DisplayName("CalculateRunner 실행 중 예외 발생 없이 실행")
    void testRunnerExecution() {
        // Given
        CalculateRunner runner = CalculateRunner.getInstance();
        String simulatedInput = "1,2:3";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // When & Then
        assertDoesNotThrow(runner::run);
    }
}
