package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        String userInput = new InputHandler().getUserInput();

        UserInputConverter userInputConverter = new UserInputConverter();
        List<String> split = userInputConverter.split(userInput);

        Numbers numbers = Numbers.of(split);

        int totalValue = numbers.calculateTotalValue();

        System.out.println(totalValue);
    }
}
