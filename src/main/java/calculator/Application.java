package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String input = "";
        ArrayList<String> seperators = new ArrayList<>(List.of(",", ":"));

        UserInput userInput = new UserInput(input, seperators);

        // 유저의 입력값을 받는다.
        userInput.input();

        input = userInput.getInput();
        seperators = userInput.getSeperators();

        Calculator calculator = new Calculator(input, seperators);

        int answer = calculator.calculate();

        UserOutput userOutput = new UserOutput(answer);

        userOutput.print();
    }
}
