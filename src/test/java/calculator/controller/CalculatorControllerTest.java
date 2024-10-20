package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest extends NsTest {

    @Test
    protected void 실행_테스트() {
        //given
        String input = "1,2";
        String expectedOutput = "덧셈할 문자열을 입력해 주세요." + System.lineSeparator() + "결과 : 3";

        //when
        run(input);

        //then
        assertEquals(expectedOutput, output());
    }

    @Override
    protected void runMain() {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.run();
    }
}