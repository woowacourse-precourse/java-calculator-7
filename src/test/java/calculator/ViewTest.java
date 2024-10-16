package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewTest {

    @Test
    @DisplayName("문자열을 입력받습니다.")
    void input() {
        // given
        String inputValue = "1:1:2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);

        // when
        View view = new View();
        String inputResult = view.input();

        // then
        Assertions.assertEquals("1:1:2", inputResult);
    }

    @Test
    @DisplayName("콘솔에 메시지를 출력합니다.")
    void printMessage() {
        // given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        View input = new View();
        input.printMessage();

        // then
        assertEquals(CalculatorConstraint.INPUT_MESSAGE, out.toString().trim());

        System.setOut(System.out);
    }
}