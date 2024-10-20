package calculator.config;

import calculator.domain.Adder;
import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterParser;
import calculator.domain.PositiveAdder;
import calculator.domain.SingleCustomDelimiterParser;

public class AppConfig {

    public Calculator calculator(String input) {
        return new Calculator(adder(), customDelimiterParser(input));
    }

    public Adder adder() {
        return new PositiveAdder();
    }

    public CustomDelimiterParser customDelimiterParser(String input) {
        return new SingleCustomDelimiterParser(input);
    }
}
