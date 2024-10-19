package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionOperatorTest {
    @Test
    void testOperator_withCustomSeparator() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();
        Addition addition = new Addition();
        FunctionOperator operator = new FunctionOperator();

        operator.inputView = inputView;
        operator.outputView = outputView;
        operator.preprocessing = preprocessing;
        operator.addition = addition;

        String input = "//;\\n1;2";
        List<String> separated = Arrays.asList("1", ";", "2");

        // 첫 글자가 '/'로 시작하는 커스텀 구분자
        assertTrue(preprocessing.firstLetter(input));
        List<String> customAndLeft = preprocessing.findCustomSeparator(input);
        assertEquals(";", customAndLeft.get(0));
        separated = preprocessing.separation(customAndLeft.get(1), Arrays.asList(",", ":", ";"));
        int result = addition.pickNumbers(separated);

        // 결과 확인
        assertEquals(3, result);
    }

    @Test
    void testOperator_withDefaultSeparators() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();
        Addition addition = new Addition();
        FunctionOperator operator = new FunctionOperator();

        operator.inputView = inputView;
        operator.outputView = outputView;
        operator.preprocessing = preprocessing;
        operator.addition = addition;

        String input = "1,2:3";
        List<String> separated = preprocessing.separation(input, Arrays.asList(",", ":"));
        int result = addition.pickNumbers(separated);

        // 결과 확인
        assertEquals(6, result);
    }
}
