package calculator.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputConsoleHandlerTest {

    @Test
    @DisplayName("계산된 결과를 콘솔에 반환한다")
    void showResult() {
        // given
        OutputConsoleHandler outputConsoleHandler = new OutputConsoleHandler();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        double result = 6;

        // then
        outputConsoleHandler.showCalculatedResult(result);
        assertThat(byteArrayOutputStream.toString()).contains("결과 : 6");

        System.setOut(System.out);

    }

}