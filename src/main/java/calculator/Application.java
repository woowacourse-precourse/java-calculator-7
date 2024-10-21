package calculator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();
        OutputHandler outputHandler = new OutputHandler();

        ArrayList<Double> positiveList = inputHandler.generatePositiveList();
        calculator.Add(positiveList);
        double result = calculator.result;
        outputHandler.printResult(result);
    }
}
