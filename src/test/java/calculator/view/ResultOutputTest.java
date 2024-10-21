package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultOutputTest {
    @DisplayName("출력시 사용되는 상수 확인")
    @Test
    void checkViewOutputMessage(){
        assertThat(ResultOutput.OutputMessage.OUTPUT_PROMPT.getMessage()).isEqualTo("결과 : ");
    }
    @DisplayName("출력 결과물 확인_정수")
    @Test
    void checkViewOutputInteger(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.promptResultOutput(new BigDecimal("3"));

        assertEquals("결과 : 3\n", outputStream.toString());

        System.setOut(originalOut);
    }
    @DisplayName("출력 결과물 확인_소수")
    @Test
    void checkViewOutputDecimal(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ResultOutput resultOutput = new ResultOutput();
        resultOutput.promptResultOutput(new BigDecimal("3.3"));

        assertEquals("결과 : 3.3\n", outputStream.toString());

        System.setOut(originalOut);
    }
}
