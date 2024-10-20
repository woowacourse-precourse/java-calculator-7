package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorUseCaseTest {

    private final CalculatorUseCase calculatorUseCase = new CalculatorUseCase();

    @AfterEach
    public void closeConsole() {
        Console.close();
    }

    @Test
    public void testReservePattern() throws Exception {
        //given
        String testInput = "1,2:3,5";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        calculatorUseCase.startCalculate();
        String result = "덧셈할 문자열을 입력해 주세요.\n결과 : 11\n";

        //then
        Assertions.assertEquals(result, outputStream.toString());
    }

    @Test
    public void testCustomPattern() throws Exception {
        //given
        String testInput = "//;\\n1;6;5";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        calculatorUseCase.startCalculate();
        String result = "덧셈할 문자열을 입력해 주세요.\n결과 : 12\n";

        //then
        Assertions.assertEquals(result, outputStream.toString());
    }

    @Test
    public void testInvalidPattern() throws Exception {
        //given
        String testInput = "sdfdsf";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorUseCase.startCalculate();
        });
    }
}
