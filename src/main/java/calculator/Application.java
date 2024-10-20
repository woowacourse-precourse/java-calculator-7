package calculator;

import calculator.domain.InputString;
import calculator.domain.StringCalculator;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        String input = Input.input();

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(new InputString(input));

        Output.output(result);
    }
}
