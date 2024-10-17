package calculator;

import calculator.contorller.CalculatorController;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;

public class CalculatorApplication {

    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final CalculatorController calculatorController = new CalculatorController();

    public void run(){
        consoleOutput.printFirstComments();
        String inputString = consoleInput.getUserInput();
        int result = calculatorController.getResult(inputString);
        consoleOutput.printResult(result);
    }
}
