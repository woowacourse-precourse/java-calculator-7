package calculator;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();
        outputService.welcome();

        outputService.printResult(InputValidator.validate(inputService.getInput()));

    }
}
