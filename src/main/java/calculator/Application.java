package calculator;

import calculator.config.CalculatorFactory;
import calculator.model.DelimiterParser;
import calculator.model.StringCalculator;
import calculator.model.SumCalculator;
import calculator.model.impl.DelimiterParserImpl;
import calculator.model.impl.SumCalculatorImpl;
import calculator.view.InputHandler;
import calculator.view.OutputHandler;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        DelimiterParser delimiterParser = new DelimiterParserImpl();
        SumCalculator sumCalculator = new SumCalculatorImpl();
        StringCalculator calculator = CalculatorFactory.createCalculator(delimiterParser, sumCalculator);


        int result = calculator.add(input);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printResult(result);
    }
}
