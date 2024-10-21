package calculator.controller;

import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import calculator.view.CalculatorView;
import java.math.BigDecimal;

public class ApplicationController {

    public static CalculatorResultDTO<BigDecimal> run(ExpressionDTO expressionDTO, CalculatorView view) {
        BigDecimal currentSum = CalculatorController.sum(java.math.BigDecimal.ZERO, expressionDTO);
        view.displayOutput(new CalculatorResultDTO<>(currentSum).toString());
        return new CalculatorResultDTO<>(currentSum);
    }
}
