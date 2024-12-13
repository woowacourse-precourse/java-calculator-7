package calculator;

import calculator.domain.Calculate;
import calculator.domain.Strings;
import calculator.io.CalculatorInput;
import calculator.io.CalculatorOutput;

public class Application {
    public static void main(String[] args) {
        CalculatorInput input = new CalculatorInput();
        CalculatorOutput output = new CalculatorOutput();

        output.printAskingString();
        Strings string = input.getString();
        Calculate calculate = new Calculate(string);
        int result = calculate.addNumbers();
        output.printResult();
        System.out.println(result);


    }
}
