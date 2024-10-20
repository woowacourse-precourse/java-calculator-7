package calculator.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("결과를 출력한다.")
    void printSum() {
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printSum(10);
        String expected = "결과 : 10\n";

        Assertions.assertThat(out.toString()).isEqualTo(expected);
    }

}