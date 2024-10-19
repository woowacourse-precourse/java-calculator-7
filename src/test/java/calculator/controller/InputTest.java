package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputTest {
    @Test
    void getUserInputTest() {
        // Given
        String sampleInput = "123456789";
        ByteArrayInputStream sampleInputStream = new ByteArrayInputStream(sampleInput.getBytes());
        System.setIn(sampleInputStream);

        // When
        String userInput = new Input().getUserInput();

        // Then
        assertThat(userInput).contains(sampleInput);
    }
}
