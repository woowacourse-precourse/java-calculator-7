package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputProcessorTest {

    void systemInMock(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 정상적인_문자열을_입력받을_수_있다() {
        InputProcessor inputProcessor = new InputProcessor();
        systemInMock("1 + 2");

        String input = inputProcessor.readInput();

        assertThat(input).isEqualTo("1 + 2");
    }

    @Test
    void 입력이_null인_경우_IllegalArgumentException_발생() {
        InputProcessor inputProcessor = new InputProcessor();

        Exception exception = assertThrows(IllegalArgumentException.class, inputProcessor::readInput);

        assertThat(exception.getMessage()).isEqualTo("Input cannot be null");
    }
}