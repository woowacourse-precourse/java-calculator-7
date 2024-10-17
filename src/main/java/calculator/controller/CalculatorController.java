package calculator.controller;

import calculator.dto.ExpressionDTO;
import calculator.model.Calculator;
import calculator.model.Parser;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.view.StringCalculatorView;
import calculator.view.View;
import java.math.BigDecimal;

public class CalculatorController {

    private final View view;

    public CalculatorController() {
        this.view = new StringCalculatorView();
    }

    public void run() {
        Parser<BigDecimal> parser = new StringParser<>(new ExpressionDTO(view.displayInput()));
        Calculator<BigDecimal> calculator = new StringCalculator<>(
                BigDecimal.ZERO,
                BigDecimal::add,
                bigDecimal -> bigDecimal.compareTo(BigDecimal.ZERO) > 0);

        BigDecimal total = calculator.calculate(parser.parse(BigDecimal::new));
        view.displayOutput(getResult(total.toString()));
    }

    private String getResult(String result) {
        BigDecimal[] intAndDecimals = new BigDecimal(result).divideAndRemainder(BigDecimal.ONE);
        if (intAndDecimals[1].equals(BigDecimal.ZERO)) {
            return intAndDecimals[0].toBigInteger().toString();
        }
        return result;
    }
}
