package calculator;

import calculator.service.StringPlusCalculator;

import static calculator.input.InputController.getInputString;
import static calculator.output.PrintOutput.printDefaultMessage;
import static calculator.output.PrintOutput.printOutput;

public class Application {

    public static void main(String[] args){
        StringPlusCalculator calculator = new StringPlusCalculator();

        printDefaultMessage();
        Integer result = calculator.plusCalculate(getInputString());
        printOutput(result);
    }
}
