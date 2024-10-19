package calculator.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void printInputRequestMessage() {
        //given
        String expectedMessage = "덧셈할 문자열을 입력해주세요";

        //when
        Out.printInputRequestMessage();

        //then
        assertEquals(byteArrayOutputStream.toString().trim(), expectedMessage);
    }

    @Test
    void printResult() {
        //given
        int testResult = 10;

        //when
        Out.printResult(testResult);

        //then
        assertEquals(byteArrayOutputStream.toString().trim(), "결과 : " + testResult);
    }
}