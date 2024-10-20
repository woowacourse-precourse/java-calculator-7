package calculator.controller;

import calculator.dto.ResultDTO;
import calculator.model.Calculator;
import calculator.model.Parser;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import java.math.BigDecimal;

public class CalculatorController {

    // 추출한 실수형에 관한 빠른 덧셈 연산 수행용
    public static ResultDTO<Double> sum(double initialValue, String expression) {
        Parser<Double> parser = new StringParser<>(expression);
        Calculator<Double> calculator = new StringCalculator<>(
                initialValue,
                Double::sum,
                validNumber -> Double.compare(validNumber, 0) > 0);

        return new ResultDTO<>(calculator.calculate(parser.parse(Double::parseDouble)));
    }

    // 추출한 실수형에 관한 정밀한 연산 수행용
    public static ResultDTO<BigDecimal> sum(BigDecimal initialValue, String expression) {
        Parser<BigDecimal> parser = new StringParser<>(expression);
        Calculator<BigDecimal> calculator = new StringCalculator<>(
                initialValue,
                BigDecimal::add,
                validNumber -> validNumber.compareTo(BigDecimal.ZERO) > 0);

        return new ResultDTO<>(calculator.calculate(parser.parse(BigDecimal::new)));
    }
}
