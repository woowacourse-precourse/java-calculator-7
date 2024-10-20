package calculator.numberStrategy;

import java.util.List;

public class SimpleNumberStrategy implements NumberStrategy {
    public SimpleNumberStrategy() {
    }

    @Override
    public List<Integer> extractNumber(String userInput, List<String> delimiter) {
        String regex = String.join("|", delimiter);
        String[] splitResults = userInput.split(regex, -1);
        return null;
    }
}
