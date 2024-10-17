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

        inputProcessor.readInput();

        assertThat(inputProcessor.getInput()).isEqualTo("1 + 2");
    }

    @Test
    void 입력이_null인_경우_IllegalArgumentException_발생() {
        InputProcessor inputProcessor = new InputProcessor();

        Exception exception = assertThrows(IllegalArgumentException.class, inputProcessor::readInput);

        assertThat(exception.getMessage()).isEqualTo("Input cannot be null");
    }

    @Test
    void 커스텀_구분자가_입력되는_경우_정상적으로_입력받을_수_있다() {
        InputProcessor inputProcessor = new InputProcessor();
        systemInMock("//;\n1;2;3");

        inputProcessor.readInput();

        assertThat(inputProcessor.getInput()).isEqualTo("//;\n1;2;3");
    }

    @Test
    void 커스텀_구분자가_존재하는_경우_true를_반환한다() {
        InputProcessor inputProcessor = new InputProcessor();
        systemInMock("//;\n1;2;3");

        inputProcessor.readInput();

        assertThat(inputProcessor.hasCustomDelimiter()).isTrue();
    }

    @Test
    void 커스텀_구분자가_존재하지_않는_경우_false를_반환한다() {
        InputProcessor inputProcessor = new InputProcessor();
        systemInMock("1 + 2");

        inputProcessor.readInput();

        assertThat(inputProcessor.hasCustomDelimiter()).isFalse();
    }

}