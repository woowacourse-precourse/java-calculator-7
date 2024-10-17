package calculator.unit.inputReader;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.inputReader.InputReader;
import calculator.mock.FakeInputReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputReaderTest {
    private final InputReader inputReader = new FakeInputReader("input");

    @Test
    @DisplayName("InputReader  동작 테스트")
    void createInputProcessor() {

        // when
        String actualInput = inputReader.readLine();

        // then
        assertThat(actualInput).isEqualTo("input");
    }

}