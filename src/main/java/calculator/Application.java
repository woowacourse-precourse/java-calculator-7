package calculator;


import calculator.controller.Calculator;
import calculator.input.Input;
import calculator.view.Output;

public class Application {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Input.printStartCalculatorMessage();
        String inputString = Input.getInputString();
        int sum = calculator.Calculate(inputString);

        Output.printOutput(sum);

    }


}


