package calculator.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputInterfaceTest {

    @Test
    void 리턴형식확인() {
        final String inputMessage = "testMessage";

        final InputUi inputUi = () -> inputMessage;
        final UserInputInterface userInputInterface = new UserInputInterface(inputUi);

        Assertions.assertThat(userInputInterface.getUserInputMessage().toString())
                .isEqualTo(inputMessage);
    }
}