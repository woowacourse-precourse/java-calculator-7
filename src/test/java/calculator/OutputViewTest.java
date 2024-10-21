package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    OutputView outputView;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // System.out을 ByteArrayOutputStream으로 리다이렉트
        System.setOut(new PrintStream(outContent));
        outputView = new OutputView();
    }

    @Test
    void testShowInputPrompt() {
        outputView.showInputPrompt();
        assertEquals("덧셈할 문자열을 입력해 주세요.\n", outContent.toString());
    }

    @Test
    void testShowResult() {
        BigDecimal result = new BigDecimal("123");
        outputView.showResult(result);
        assertEquals("결과 : 123\n", outContent.toString());
    }

    @BeforeEach
    public void tearDown() {
        // 테스트 완료 후, System.out을 원래대로 돌림
        System.setOut(originalOut);
    }
}
