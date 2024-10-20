package calculator.NumberStrategy;

import java.util.List;

public interface NumberStrategy {
    public List<Integer> extractNumber(String userInput, List<String> delimiter);
}
