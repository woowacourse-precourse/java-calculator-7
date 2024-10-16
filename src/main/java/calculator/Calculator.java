package calculator;

public class Calculator {

    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final Validator validator = new Validator();

    public void run(){
        consoleOutput.showFirstComments();
        String inputString = consoleInput.getUserInput();
        validator.isCustom(inputString);
        consoleOutput.showResult(6);
    }
}
