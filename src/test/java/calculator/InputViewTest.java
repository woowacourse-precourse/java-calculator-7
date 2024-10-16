package calculator;

import calculator.view.InputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 사용자_입력을_성공적으로_읽는다() {
        String input = "1,2,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String actual = inputView.readInput();

        assertEquals(input, actual);
    }

}
