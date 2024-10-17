package calculator;

import calculator.io.InputParseResult;
import calculator.io.InputOutputHandler;

public class Application {
    public static void main(String[] args) {
        ApplicationFactory factory = new ApplicationFactory();
        InputOutputHandler handler = factory.getInputOutputHandler();
        StringCalculator stringCalculator = factory.getStringCalculator();
        
        InputParseResult input = handler.handleInput();
        int result = stringCalculator.calculate(input.customSeparatorPart(), input.numberPart());
        handler.handleOutput(result);
    }
}
