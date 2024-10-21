package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void 출력_메시지_테스트() {
        int result = 3;
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printResult(result);
        Assertions.assertEquals(InfoMessage.RESULT.getMsg().formatted(result), out.toString());
    }
}