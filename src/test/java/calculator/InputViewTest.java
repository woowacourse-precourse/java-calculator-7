package calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 입력_안내_메시지_테스트() {
        String input = "3,4";
        InputView inputView = new InputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputView.input();
        Assertions.assertEquals(InfoMessage.INPUT.getMsg(), out.toString());
    }

}