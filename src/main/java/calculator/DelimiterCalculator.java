package calculator;

import java.util.List;

public class DelimiterCalculator implements Calculator {
    private final LineTokenizer lineTokenizer;

    public DelimiterCalculator(LineTokenizer lineTokenizer) {
        this.lineTokenizer = lineTokenizer;
    }

    @Override
    public int calculate(String input) {
        boolean hasCustomDelimiter = checkCustomDelimiter(input);
        if (hasCustomDelimiter) {
            input = input.substring(5);
        }
        List<Integer> numbers = lineTokenizer.tokenize(input);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private boolean checkCustomDelimiter(String input) {
        if (input.startsWith("//") && input.length() > 4) {
            char delimiter = input.charAt(2);
            if (input.charAt(3) != '\\' || input.charAt(4) != 'n') {
                throw new IllegalArgumentException("Invalid input");
            }
            lineTokenizer.addDelimiter(delimiter);
            return true;
        }
        return false;
    }


}
