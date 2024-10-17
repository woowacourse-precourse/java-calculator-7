package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {
        System.out.println(Message.START.getMessage());

        String userInput = Console.readLine();
        InputHandler inputHandler = new InputHandler(userInput);

        List<String> numbers = inputHandler.extractNumber();
        Validator.validate(numbers);

        Calculator calculator = new Calculator(numbers);
        int answer = calculator.sum();

        System.out.println(Message.END.getMessage() + answer);
    }
}