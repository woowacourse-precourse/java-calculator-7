package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Parser;
import calculator.model.StringCalculator;
import calculator.model.StringParser;
import java.math.BigDecimal;

public class CalculatorController {

    public static String sum(double initialValue, String expression) {
        Parser<Double> parser = new StringParser<>(expression);
        Calculator<Double> calculator = new StringCalculator<>(
                initialValue,
                Double::sum,
                validNumber -> Double.compare(validNumber, 0) > 0);
        Double total = calculator.calculate(parser.parse(Double::parseDouble));
        return getResult(total.toString());
    }

    // Double형보다 큰 범위에서 덧셈 연산을 수행할 때 사용
    public static String sum(BigDecimal initialValue, String expression) {
        Parser<BigDecimal> parser = new StringParser<>(expression);
        Calculator<BigDecimal> calculator = new StringCalculator<>(
                initialValue,
                BigDecimal::add,
                validNumber -> validNumber.compareTo(BigDecimal.ZERO) > 0);

        BigDecimal total = calculator.calculate(parser.parse(BigDecimal::new));
        return getResult(total.toString());
    }

    private static String getResult(String result) {
        BigDecimal[] intAndDecimals = new BigDecimal(result).divideAndRemainder(BigDecimal.ONE);
        BigDecimal integer = intAndDecimals[0];
        BigDecimal decimals = intAndDecimals[1];

        // 소수점 이하의 유효한 값이 존재하는지 확인
        if (decimals.equals(BigDecimal.ZERO)) {
            return integer.toBigInteger().toString();
        }
        return result;
    }
}
