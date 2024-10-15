package calculator.ui;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputConsoleTest {

    @Test
    void 사용자입력() {
        final String inputMessage = "Hello WoowaTech";
        System.setIn(new ByteArrayInputStream(inputMessage.getBytes()));

        final InputConsole inputConsole = new InputConsole();

        Assertions.assertThat(inputConsole.readLine().equals(inputMessage));
    }
}