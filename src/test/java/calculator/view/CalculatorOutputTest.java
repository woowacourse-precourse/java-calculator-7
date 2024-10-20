package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorOutputTest {

    CalculatorOutput calculatorOutput;
    OutputStream out;

    @BeforeEach
    void setUp() {
        calculatorOutput = new CalculatorOutput();
        out = new ByteArrayOutputStream();
    }

    @Test
    void 결과_출력() {
        //given
        Integer result = 6;
        System.setOut(new PrintStream(out));

        //when
        calculatorOutput.printResult(result);

        //then
        assertThat(out.toString()).contains("결과 : 6");
    }

}