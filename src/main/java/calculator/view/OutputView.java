package calculator.view;

import static calculator.common.Constants.OUTPUT_PROMPT;

public class OutputView {
    public void printResult (Integer result) {
        System.out.println(OUTPUT_PROMPT + result);
    }
}
