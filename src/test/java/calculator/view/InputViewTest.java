package calculator.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private  final InputView inputView = new InputView();

    @Test
    void 정상적인_입력_처리() {
        String input = "1,2,3";
        provideInput(input);

        String result = inputView.readInput();

        assertThat(result).isEqualTo(input);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}