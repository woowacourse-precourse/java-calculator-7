package calculator.view;

import static org.junit.jupiter.api.Assertions.*;

import calculator.config.AppConfig;
import org.junit.jupiter.api.Test;

class InputViewTest {
    AppConfig appConfig = new AppConfig();

    @Test
    void inputString() {
        InputView inputView = appConfig.inputView();

        String simulatedInput = "강아지";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        String result = inputView.getInput();
        assertEquals(simulatedInput, result);
    }
}