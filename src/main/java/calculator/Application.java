package calculator;

import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.DefaultDelimiter;
import calculator.delimiter.Delimiter;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();

        outputService.welcome();

        String input = inputService.getInput();
        Delimiter delimiter = isCustomDelimiter(input);

        Parser parser = new Parser();
        InputValidator inputValidator = new InputValidator(delimiter, parser);

        outputService.printResult(inputValidator.validate(input));
    }

    private static Delimiter isCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            return new CustomDelimiter();
        }
        return new DefaultDelimiter();
    }
}
