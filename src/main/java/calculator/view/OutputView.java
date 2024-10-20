package calculator.view;

import static calculator.config.SystemConstantMessages.VIEW_CLASS_MESSAGE;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException(VIEW_CLASS_MESSAGE);
    }

    public static void printResult(Integer result) {
        System.out.println(result);
    }
}
