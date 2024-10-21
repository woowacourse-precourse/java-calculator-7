package calculator;

import calculator.operator.AdditionOperator;
import calculator.operator.Operator;
import calculator.parser.DelimiterConfig;
import calculator.parser.StringDelimiterParser;
import calculator.parser.Parser;
import calculator.util.InputReceiver;
import calculator.util.ResultPrinter;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        String input = InputReceiver.readInput();

        Parser parser = new StringDelimiterParser(DelimiterConfig.DEFAULT);
        Operator operator = new AdditionOperator();
        StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator(operator, parser);

        BigDecimal result = stringAdditionCalculator.calculate(input);
        ResultPrinter.printResult(result);
    }
}
