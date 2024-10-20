package calculator;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        OutputService outputService = new OutputService();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        InputValidator inputValidator = new InputValidator(customDelimiter);

        outputService.welcome();
        outputService.printResult(inputValidator.validate(inputService.getInput()));
    }
}
