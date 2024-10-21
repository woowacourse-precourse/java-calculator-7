package calculator.view;

import java.math.BigDecimal;

public class OutputView {

    private OutputView() {
    }

    public static OutputView createOutputView() {
        return new OutputView();
    }

    public void printMessage(Output output) {
        System.out.println(output.message);
    }

    public void printMessage(Output output, double result) {
        System.out.println(output.message + BigDecimal.valueOf(result).stripTrailingZeros());
    }
}
