package calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorViewTest {

    public static final CalculatorView calculatorview = new CalculatorView();

    @Test
    public void testInputView() throws Exception {
        //given
        //todo console.readLine 테스트 알아보기.
        String testInput = "hello";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        //when
        String input = calculatorview.inputView();
        String result = "hello";

        //then
        Assertions.assertEquals(result, input);
    }

    @Test
    public void testOutputView() throws Exception {
        //given
        String testOutput = "결과: 3\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        calculatorview.outputView(3);

        //then
        Assertions.assertEquals(testOutput, outputStream.toString());
    }
}
