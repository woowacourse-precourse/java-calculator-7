package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import calculator.parser.Parser;
import calculator.validation.InputValidator;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();

        outputService.welcome();

        String input = inputService.getInput();
        Delimiter delimiter = DelimiterFactory.createDelimiter(input);

        Parser parser = new Parser();
        InputValidator inputValidator = new InputValidator(delimiter, parser);

        outputService.printResult(inputValidator.validate(input));
    }
}
