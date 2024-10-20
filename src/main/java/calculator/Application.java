package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.ResultDTO;
import calculator.view.StringCalculatorView;
import java.math.BigDecimal;

public class Application {

    private static final StringCalculatorView view = new StringCalculatorView();

    public static void main(String[] args) {
        ResultDTO<BigDecimal> totalSum = CalculatorController.sum(BigDecimal.ZERO, view.displayInput());
        view.displayOutput(totalSum.getTotal());
    }
}