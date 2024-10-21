package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 사용자입력_테스트() {
        InputView inputView = new InputView();
        String userInput = "Test";
        String noInput = "Code";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String input = inputView.getInput();

        Assertions.assertThat(input).isEqualTo(userInput);
        Assertions.assertThat(input).isNotEqualTo(noInput);
    }

}