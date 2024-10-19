package calculator.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        outputView = new OutputView();
    }

    @AfterEach
    void restoreStream() {
        System.setOut(printStream);
    }

    @Test
    void printCalculateResultTest() {
        // given
        int result = 5;

        // when
        outputView.printCalculateResult(result);

        //then
        Assertions.assertThat(outputStream.toString()).isEqualTo("결과 : 5\n");
    }

}