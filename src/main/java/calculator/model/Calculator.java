package calculator.model;

import java.util.List;

public class Calculator {

    MessageParser messageParser;

    public int calculate(String message) {
        this.messageParser = new MessageParser(message);

        List<Integer> numbers = messageParser.parseNumbers();
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
