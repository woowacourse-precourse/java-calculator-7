package calculator.util;

import calculator.domain.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public void parsing(Calculator calculator, String input) {
        char identifier = parseIdentifier(calculator, input);
        String expression = parseExpression(identifier, input);
        List<Long> operands = extractOperands(calculator, expression);
        calculator.addOperands(operands);
    }

    private char parseIdentifier(Calculator calculator, String input) {
        if(matches(input)) {
            calculator.addIdentifier(input.charAt(2));
            return input.charAt(2);
        }
        return '\0';
    }

    private String parseExpression(char identifier, String input) {
        if(identifier != '\0') {
            return input.substring(4);
        }
        return input;
    }

    private List<Long> extractOperands(Calculator calculator, String expression) {
        List<Long> operands = new ArrayList<>();
        String[] numbers = expression.split(calculator.identifiersToString());

        try {
            for (String number : numbers) {
                operands.add(Long.parseLong(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("식에는 숫자와 구분자만 입력 가능합니다.");
        }

        return operands;
    }

    private boolean matches(String input) {
        Pattern pattern = Pattern.compile("//.\n.+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
