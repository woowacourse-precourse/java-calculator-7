package calculator;

public class Calculator {

    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();

    public void run(){
        consoleOutput.showFirstComments();
        String inputString = consoleInput.getUserInput();
        System.out.println(inputString);
        consoleOutput.showResult(6);
    }
}
