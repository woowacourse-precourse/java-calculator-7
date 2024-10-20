package calculator;

import calculator.operands.Operands;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Parser {

    private String customDelimiters = "";
    private final HashSet<String> delimiters = new HashSet<>();

    private String equation = "";
    private final String customDelimiterStart;
    private final String customDelimiterEnd;

    Parser(String input) {
        this.equation = input;
        this.customDelimiterStart = "//";
        this.customDelimiterEnd = "\\n";
    }

    Parser(String input, String customDelimiterStart,
           String customDelimiterEnd) {
        this.equation = input;
        this.customDelimiterStart = customDelimiterStart;
        this.customDelimiterEnd = customDelimiterEnd;
    }

    private void separateCustomDelimiter() {
        if (equation.startsWith(customDelimiterStart)) {
            int delimEndIndex = equation.lastIndexOf(customDelimiterEnd);
            if (delimEndIndex != -1) {
                customDelimiters = equation.substring(customDelimiterStart.length(), delimEndIndex);
                equation = equation.substring(delimEndIndex + customDelimiterEnd.length());
            }
        }
    }

    private void parseDelimiter() {
        delimiters.add(",");
        delimiters.add(":");

        customDelimiters.codePoints()
                .forEach(codePoint -> {
                    String character = new String(Character.toChars(codePoint));
                    delimiters.add(character);
                });
    }

    private <E extends Number> void parseOperands(Operands<E> operands) {
        StringBuilder sb = new StringBuilder();
        for (String c : delimiters) {
            sb.append(c);
        }
        String regEx = "[" + Pattern.quote(sb.toString()) + "]";

        String[] numbers = equation.split(regEx);
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            } else if (!operands.validate(number)) {
                throw new IllegalArgumentException();
            } else {
                operands.addOperand(number);
            }
        }
    }

    public <E extends Number> Operands<E> parseEquation(Operands<E> operands) {
        separateCustomDelimiter();
        parseDelimiter();
        parseOperands(operands);
        return operands;
    }
}
