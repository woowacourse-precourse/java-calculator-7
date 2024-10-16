package calculator;

import java.io.IOException;

import static calculator.InputController.getInputString;
import static calculator.PrintOutput.printOutput;

public class Application {

    public static void main(String[] args) throws IOException {
        StringPlusCalculator calculator = new StringPlusCalculator();

        Integer result = calculator.plusCalculate(getInputString());
        printOutput(result);
    }
}
