package calculator;


import calculator.Calculator.Calculator;
import calculator.Calculator.CalculatorService;
import calculator.input.Input;
import calculator.input.InputValidator;
import calculator.view.Output;

public class Application {

    public static void main(String[] args) {

        InputValidator inputValidator = new InputValidator();
        CalculatorService calculatorService = new CalculatorService();

        Calculator calculator = new Calculator(inputValidator, calculatorService);

        Input.printStartCalculatorMessage();
        String inputString = Input.getInputString();
        int sum = calculator.Calculate(inputString);

        Output.printOutput(sum);

    }


}


