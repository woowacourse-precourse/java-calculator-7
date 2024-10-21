package calculator;

import calculator.controller.ApplicationController;
import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import calculator.view.StringCalculatorView;
import java.math.BigDecimal;

public class Application {

    private static final StringCalculatorView view = new StringCalculatorView();

    private static BigDecimal totalSum = BigDecimal.ZERO;

    public static void main(String[] args) {
        CalculatorResultDTO<BigDecimal> currentSum;
        do {
            String input;
            try {
                input = view.displayInput();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            }
            currentSum = ApplicationController.run(new ExpressionDTO(input), view);
            totalSum = totalSum.add(currentSum.get());
        } while (!currentSum.get().equals(BigDecimal.ZERO));
        view.displayOutput(new CalculatorResultDTO<>(totalSum));
    }
}