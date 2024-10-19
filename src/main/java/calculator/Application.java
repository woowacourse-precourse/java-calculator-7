package calculator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();

        // 유저의 입력값을 받는다.
        userInput.input();

        String input = userInput.getInput();
        ArrayList<String> separators = userInput.getSeperators();

        Calculator calculator = new Calculator(input, separators);

        int answer = calculator.calculate();

        UserOutput userOutput = new UserOutput(answer);

        userOutput.print();
    }
}
