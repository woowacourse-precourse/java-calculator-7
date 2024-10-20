package calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IOTest {

    private IO io;

    @Test
    public void 콘솔_입출력_테스트() throws Exception {
        //Given
        io = new ConsoleIO();

        // 콘솔 입력 스트림 리다이렉션
        String input = "TEST";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // 콘솔 출력 스트림 리다이렉션
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        //When
        String output = io.read();
        io.write(output);

        //Then
        Assertions.assertThat(output).contains(input);
        Assertions.assertThat(testOut.toString()).contains(String.format("결과 : %s", output));
    }
}