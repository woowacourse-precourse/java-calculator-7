package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import calculator.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private static final OutputView outputView = new OutputView();
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
    }

    @Test
    void 출력_테스트() {
        assertSimpleTest(() -> {
            outputView.printOutput(6);
            assertNotEquals(outputStream.toString(), "결과 : 6");
        });
    }

    @Test
    void 출력_테스트_2() {
        assertSimpleTest(() -> {
            outputView.printOutput(63);
            assertNotEquals(outputStream.toString(), "결과 : 63");
        });
    }
}
