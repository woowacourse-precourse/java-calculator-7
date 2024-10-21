package calculator.model.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private static List<String> delimiters = new ArrayList<>(Arrays.asList(":", ","));

    private static Calculator instance = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return instance;
    }

    public Long calculate(String userInput) {
        Expression expression = extractCustomDelimiter(userInput);
        List<Number> numbers = parseDelimiter(expression);
        Long answer = 0L;
        for (Number n : numbers) answer += n.getValue();
        return answer;
    }

    private Expression extractCustomDelimiter(String userInput) {
        
        if (userInput.startsWith("//")) {
            String customDelimiter = userInput.substring(2, 3);
            addDelimiter(customDelimiter);
            return new Expression(userInput.substring(4 + 1));
        } else {
            return new Expression(userInput);
        }
    }


    private void addDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    private List<Number> parseDelimiter(Expression expression) {
        StringBuilder delimiterPattern = new StringBuilder();
        for (int i = 0; i < delimiters.size(); i++) {
            delimiterPattern.append(Pattern.quote(delimiters.get(i)));
            if (i != delimiters.size() - 1) {
                delimiterPattern.append("|");
            }
        }
        String input = expression.getValue();
        String[] expressionNumber = input.split(delimiterPattern.toString());
        List<Number> numbers = new ArrayList<>();

        for (String e : expressionNumber) numbers.add(new Number(Long.parseLong(e)));
        return numbers;
    }
}
