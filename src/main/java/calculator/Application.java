package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import calculator.view.StringCalculatorView;
import java.math.BigDecimal;

public class Application {

    private static final StringCalculatorView view = new StringCalculatorView();

    public static void main(String[] args) {
        ExpressionDTO expression = new ExpressionDTO(view.displayInput());
        CalculatorResultDTO<BigDecimal> totalSum = CalculatorController.sum(BigDecimal.ZERO, expression);
        view.displayOutput(totalSum.getTotal());
    }
}