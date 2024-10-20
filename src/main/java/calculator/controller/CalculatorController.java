package calculator.controller;

import calculator.dto.ResultDTO;
import calculator.model.Calculator;
import calculator.model.Parser;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import java.math.BigDecimal;

public class CalculatorController {

    public static ResultDTO<Double> sum(double initialValue, String expression) {
        Parser<Double> parser = new StringParser<>(expression);
        Calculator<Double> calculator = new StringCalculator<>(
                initialValue,
                Double::sum,
                validNumber -> Double.compare(validNumber, 0) > 0);

        return new ResultDTO<>(calculator.calculate(parser.parse(Double::parseDouble)));
    }

    // Double형보다 큰 범위에서 덧셈 연산을 수행할 때 사용
    public static ResultDTO<BigDecimal> sum(BigDecimal initialValue, String expression) {
        Parser<BigDecimal> parser = new StringParser<>(expression);
        Calculator<BigDecimal> calculator = new StringCalculator<>(
                initialValue,
                BigDecimal::add,
                validNumber -> validNumber.compareTo(BigDecimal.ZERO) > 0);

        return new ResultDTO<>(calculator.calculate(parser.parse(BigDecimal::new)));
    }
}
