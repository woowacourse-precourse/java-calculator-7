package calculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // System.out을 ByteArrayOutputStream으로 대체하여 출력을 캡처
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("CalculatorController 정상 동작 확인")
    void run() {
        // given
        String input = "1,2:3";
        String expect = "결과 : 6\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CalculatorController calculatorController = new CalculatorController();

        // when
        calculatorController.run();
        String result = outContent.toString().replace("덧셈할 문자열을 입력해 주세요.\n", ""); // 출력 결과 가로채기

        // then
        assertEquals(expect, result);
    }

}
