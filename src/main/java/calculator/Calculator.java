package calculator;

import java.util.ArrayList;
import java.util.List;
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

        // TODO: 문자열에서 숫자를 파싱해 operands 에 추가하는 로직 구현

        List<Integer> numbers = new ArrayList<>();
        operands.addAll(numbers);
    }

    public int sum() {
        int result = 0;
        for (int num : operands) {
            result += num;
        }
        return result;
    }
}
