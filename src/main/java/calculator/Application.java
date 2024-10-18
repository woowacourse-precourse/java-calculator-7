package calculator;

import calculator.view.CalculatorRequest;

public class Application {
    public static void main(String[] args) {
        CalculatorRequest calculatorRequest = new CalculatorRequest();

        calculatorRequest.getStartMessage();
        calculatorRequest.inputString();
    }
}
