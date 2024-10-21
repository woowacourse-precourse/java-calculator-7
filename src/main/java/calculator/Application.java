package calculator;

import calculator.domain.Number;
import calculator.domain.UserInput;
import calculator.io.Input;
import calculator.io.Ouput;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Ouput output = new Ouput();

        output.run();
        String parseInput = new UserInput(input.read()).parseInput();
        int result = new Number(parseInput).sum();
        output.result(result);

    }
}
