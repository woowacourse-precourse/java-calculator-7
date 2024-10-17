package calculator.unit.inputReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.inputReader.ConsoleInputReader;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleInputReaderTest {


    @Test
    @DisplayName("ConsoleInputReader  입력 안하면 에러 뜬다 테스트")
    void createInputProcessor() {
        String expectMessage = "No line found";

        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        // then
        assertThatThrownBy(() -> consoleInputReader.readLine())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining(expectMessage);


    }


}