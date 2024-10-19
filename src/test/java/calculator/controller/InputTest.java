package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputTest {
    /**
     * 특수 문자 없는 입력값을 받는지 확인한다.
     */
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

    /**
     * 특수 문자 \n 을 정상적으로 처리하는지 확인.
     */
    @Test
    void getUserInputTestTwo() {
        // Given
        String sampleString = "//;\\n1;2;3";
        ByteArrayInputStream sampleStringByteArray = new ByteArrayInputStream(sampleString.getBytes());
        System.setIn(sampleStringByteArray);

        // When
        String userInput = new Input().getUserInput();

        // Then
        assertEquals(userInput, sampleString);
    }
}
