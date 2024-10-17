package calculator;

import calculator.domain.Calculator;
import calculator.domain.prompt.CalculatorPrompt;
import calculator.domain.prompt.Prompt;

public class Application {

    public static void main(String[] args) {
        Prompt prompt = new CalculatorPrompt("//+\n1,2:3+4");
        Calculator calculator = new Calculator(prompt);
        int sum = calculator.sum();
        System.out.println(sum);
    }

}
