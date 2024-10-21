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
        // given
        InputProcessor inputProcessor = new InputProcessor();
        systemInMock("1 + 2");

        // when
        String input = inputProcessor.readInput();

        // then
        assertThat(input).isEqualTo("1 + 2");
    }

    @Test
    void 입력이_null인_경우_IllegalArgumentException_발생() {
        // given
        InputProcessor inputProcessor = new InputProcessor();

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, inputProcessor::readInput);
        assertThat(exception.getMessage()).isEqualTo("Input cannot be null");
    }
}