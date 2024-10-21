package calculator;

import calculator.controller.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringCalculator calculator = new StringCalculator();

        String input = inputView.getInput();
        if (input == null || input.trim().isBlank()) {
            outputView.printResult(BigDecimal.valueOf(0));
        } else {
            BigDecimal sum = calculator.calculateInput(input);
            outputView.printResult(sum);
        }

    }
}
