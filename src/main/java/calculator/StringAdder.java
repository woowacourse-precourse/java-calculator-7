package calculator;

import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;

public class StringAdder {
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final Validator validator = new Validator();
    private final CustomCalculator customCalculator = new CustomCalculator();

    public void run(){
        consoleOutput.printFirstComments();
        String inputString = consoleInput.getUserInput();
        //커스텀 구분자인 경우
        if (validator.isCustom(inputString)){
            System.out.println(customCalculator.calculate(inputString));
        }
    }
}
