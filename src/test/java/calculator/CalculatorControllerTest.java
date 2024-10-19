package calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {

    private final CalculatorController calculatorController = new CalculatorController();

    @Test
    public void testStartCalculate() throws Exception {
        //given
        String testInput = "1,2:3";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        calculatorController.startCalculate();
        String result = "덧셈할 문자열을 입력해 주세요.\n결과 : 6\n";

        //then
        Assertions.assertEquals(result, outputStream.toString());
    }
}
