package calculator;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        InputController inputController = new InputController();
        PrintOutput printOutput = new PrintOutput();
        StringPlusCalculator calculator = new StringPlusCalculator();

        InputString inputString = inputController.getInputString();
        Integer result = calculator.plusCalculate(inputString);
        printOutput.printOutput(result);
    }
}
