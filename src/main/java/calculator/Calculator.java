package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {
    private final ArrayList<Integer> operands;

    public Calculator() {
        operands = new ArrayList<>();
    }

    public void parseAndAddNumbers(String input) {
        String customDelimiter = null;
        if (input.startsWith("//")) {
            customDelimiter = InputParser.extractCustomDelimiter(input);
        }
        String numbersSection = InputParser.extractNumbersSection(input);

        String delimiters = "[,:]";
        if (customDelimiter != null) {
            delimiters += "|" + Pattern.quote(customDelimiter);
        }

        String[] tokens = numbersSection.split(delimiters);
        InputValidator.validateNumbers(tokens);

        for (String token : tokens) {
            operands.add(Integer.parseInt(token.trim()));
        }
    }

    public int sum() {
        int result = 0;
        for (int num : operands) {
            result += num;
        }
        return result;
    }
}
