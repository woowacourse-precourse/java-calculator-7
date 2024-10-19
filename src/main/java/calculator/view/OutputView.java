package calculator.view;

import calculator.view.console.ConsoleWriter;
import java.math.BigDecimal;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : %s";

    public void printResult(BigDecimal number) {
        ConsoleWriter.printlnMessage(generateResultMessage(number));
    }

    private String generateResultMessage(BigDecimal number) {
        return String.format(RESULT_MESSAGE, number);
    }
}
