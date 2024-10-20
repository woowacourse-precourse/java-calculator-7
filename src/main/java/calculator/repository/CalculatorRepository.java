package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class CalculatorRepository {

    private final List<Character> delimiters = new ArrayList<>();

    public CalculatorRepository() {
        initBasicDelimiter();
    }

    public boolean createCustomDelimiter(Character customDelimiter) {
        return delimiters.add(customDelimiter);
    }

    public List<Character> getDelimiters() {
        return delimiters;
    }

    private void initBasicDelimiter() {
        delimiters.add(',');
        delimiters.add(':');
    }
}
