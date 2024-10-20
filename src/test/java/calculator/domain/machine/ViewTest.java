package calculator.domain.machine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTest {

    View view = new View();
    ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void printInputRequestMsg() {
        // given
        // when
        view.printInputRequestMsg();

        // then
        assertEquals("덧셈할 문자열을 입력해 주세요.", outputStream.toString().trim());
    }

    @Test
    void readInputMsg() {
        // given
        String input = "2:3:4";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String readInput = view.readInputMsg();

        // then
        assertEquals(input, readInput);
    }

    @Test
    void printResult() {
        // given
        // when
        view.printResult(6L);

        // then
        assertEquals("결과 : 6", outputStream.toString().trim());
    }
}