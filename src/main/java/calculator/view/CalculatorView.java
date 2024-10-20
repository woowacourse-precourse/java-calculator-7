package calculator.view;

import calculator.util.InputUtils;

public class CalculatorView {
    private static final String INPUT_CALCULATOR_START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_CALCULATOR_RESULT_MESSAGE = "결과 : %d";

    public String readCalculatorInput() {
        System.out.println(INPUT_CALCULATOR_START_MESSAGE);
        return InputUtils.readInput();
    }

    public void printCalculatorResult(int result) {
        System.out.printf(OUTPUT_CALCULATOR_RESULT_MESSAGE, result);
    }
}
