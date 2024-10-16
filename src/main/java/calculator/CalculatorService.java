package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private static final List<String> DEFAULT_SEPARATOR = List.of(":", ",");

    private final List<String> separators;

    public CalculatorService() {
        separators = new ArrayList<>(DEFAULT_SEPARATOR);
    }

    public void addSeparator(String newSeparator) {
        if(!separators.contains(newSeparator)) {
            separators.add(newSeparator);
        }
    }
}
