package calculator;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();
        Delimiter delimiter = new Delimiter();
        InputValidator inputValidator = new InputValidator(delimiter);

        outputService.welcome();
        outputService.printResult(inputValidator.validate(inputService.getInput()));
    }
}
