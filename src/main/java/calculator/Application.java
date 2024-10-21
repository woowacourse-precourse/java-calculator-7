package calculator;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();

        outputService.welcome();

        String input = inputService.getInput();
        Delimiter delimiter = isCustomDelimiter(input);
        InputValidator inputValidator = new InputValidator(delimiter);

        outputService.printResult(inputValidator.validate(input));
    }

    private static Delimiter isCustomDelimiter(String input) {
        Delimiter delimiter= new Delimiter();
        if (input.startsWith("//")) {
            delimiter = new CustomDelimiter();
        }
        return delimiter;
    }
}
