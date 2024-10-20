package calculator;

import calculator.controller.StringCalculator;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new Input(), new Output());
        stringCalculator.run();
    }
}
