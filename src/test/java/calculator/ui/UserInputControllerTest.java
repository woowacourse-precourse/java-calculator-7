package calculator.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputControllerTest {

    @Test
    void 리턴형식확인() {
        final String inputMessage = "testMessage";

        final InputUi inputUi = () -> inputMessage;
        final UserInputController userInputController = new UserInputController(inputUi);

        Assertions.assertThat(userInputController.getUserInputMessage().toString())
                .isEqualTo(inputMessage);
    }
}