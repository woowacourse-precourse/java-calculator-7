package calculator.config;

import calculator.calculator.StringCalculator;
import calculator.calculator.operator.impl.Addition;
import calculator.extractor.DelimiterExtractor;
import calculator.extractor.NumberExtractor;
import calculator.io.IOService;
import calculator.io.impl.ConsoleIOService;
import calculator.parsing.StringNumberParser;
import calculator.parsing.UserInputParser;
import calculator.service.CalculatorService;

public class AppConfig {

    public CalculatorService calculatorService() {
        return new CalculatorService(stringCalculator(), ioService());
    }

    public StringCalculator stringCalculator() {
        return new StringCalculator(userInputParser(), new Addition());
    }

    private UserInputParser userInputParser() {
        return new UserInputParser(new DelimiterExtractor(), new NumberExtractor(), new StringNumberParser());
    }

    public IOService ioService() {
        return new ConsoleIOService();
    }
}
