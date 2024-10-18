package calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
}
