package calculator;

import static calculator.InputController.getInputString;
import static calculator.PrintOutput.printDefaultMessage;
import static calculator.PrintOutput.printOutput;

public class Application {

    public static void main(String[] args){
        StringPlusCalculator calculator = new StringPlusCalculator();

        printDefaultMessage();
        Integer result = calculator.plusCalculate(getInputString());
        printOutput(result);
    }
}
