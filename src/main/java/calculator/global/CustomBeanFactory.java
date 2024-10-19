package calculator.global;

import calculator.calculator.Calculator;
import calculator.calculator.CalculatorController;
import calculator.calculator.StringCalculator;
import calculator.calculator.StringTokenProvider;
import calculator.calculator.TokenProvider;
import calculator.delimiter.DelimiterFactory;

public class CustomBeanFactory {

    public DelimiterFactory delimiterFactory() {
        return new DelimiterFactory();
    }

    public TokenProvider tokenProvider() {
        return new StringTokenProvider(delimiterFactory());
    }

    public Calculator calculator() {
        return new StringCalculator(tokenProvider());
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(calculator());
    }
}