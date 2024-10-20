package calculator;

import calculator.Calculator.Calculator;
import calculator.Calculator.CalculatorService;
import calculator.Calculator.StringCalculator;
import calculator.Delimiter.CustomDelimiter;
import calculator.Delimiter.DefaultDelimiter;
import calculator.Delimiter.Delimiter;
import calculator.Delimiter.DelimiterParser;
import java.util.ArrayList;

public class AppConfig {

    public DelimiterParser delimiterParser() {
        ArrayList<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(defaultDelimiter());
        delimiters.add(customDelimiter());
        return new DelimiterParser(delimiters);
    }

    public DefaultDelimiter defaultDelimiter() {
        return new DefaultDelimiter();
    }

    public CustomDelimiter customDelimiter() {
        return new CustomDelimiter();
    }

    public Calculator calculator() {
        return new StringCalculator();
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(delimiterParser(), calculator());
    }

}
