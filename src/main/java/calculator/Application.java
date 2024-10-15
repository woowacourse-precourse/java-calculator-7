package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        String userInput = "//1\n2,3:4";

        UserInputConverter userInputConverter = new UserInputConverter();
        List<String> split = userInputConverter.split(userInput);

        System.out.println(userInput);
        System.out.println(split);
    }
}
