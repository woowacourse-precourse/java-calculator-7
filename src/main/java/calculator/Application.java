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
    }
}
