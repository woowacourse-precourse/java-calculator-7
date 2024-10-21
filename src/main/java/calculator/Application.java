package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import calculator.view.StringCalculatorView;
import java.math.BigDecimal;

public class Application {

    private static final StringCalculatorView view = new StringCalculatorView();

    public static void main(String[] args) {
        BigDecimal totalSum = BigDecimal.ZERO;
        while (true) {
            String input;
            try {
                input = view.displayInput();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            }
            BigDecimal currentSum = CalculatorController.sum(BigDecimal.ZERO, new ExpressionDTO(input));
            view.displayOutput(new CalculatorResultDTO<>(currentSum).getTotal());
            if (currentSum.equals(BigDecimal.ZERO)) {
                view.displayOutput(new CalculatorResultDTO<>(totalSum));
                break;
            }
            totalSum = totalSum.add(currentSum);
        }
    }
}