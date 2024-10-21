package calculator;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();
        InputValidator inputValidator = new InputValidator();

        outputService.welcome();
        outputService.printResult(inputValidator.validate(inputService.getInput()));
    }
}
