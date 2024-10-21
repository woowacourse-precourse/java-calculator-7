package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import calculator.view.StringCalculatorView;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;

public class Application {

    private static final StringCalculatorView view = new StringCalculatorView();

    public static void main(String[] args) {
        BigDecimal currentValue = BigDecimal.ZERO;
        while (true) {
            ExpressionDTO expression;
            try {
                expression = new ExpressionDTO(view.displayInput());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            }
            CalculatorResultDTO<BigDecimal> totalSum = CalculatorController.sum(currentValue, expression);
            view.displayOutput(totalSum.getTotal());
            if (totalSum.getTotal().equals("0")) {
                view.displayOutput(currentValue.toString());
                break;
            }
            currentValue = new BigDecimal(totalSum.getTotal());
        }
        Console.close();
    }
}