package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {
    private static ByteArrayOutputStream outputStream;

    CalculatorController calculatorController = new CalculatorController();

    @BeforeEach
    void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        Console.close();
    }

    @Test
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            System.setIn(createUserInput("1,2:3"));
            calculatorController.run();
            assertThat(outputStream.toString().split("\n")[1]).isEqualTo("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            System.setIn(createUserInput("//*\\n1*2*2"));
            calculatorController.run();
            assertThat(outputStream.toString().split("\n")[1]).isEqualTo("결과 : 5");
        });
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
