package calculator.service;

import calculator.domain.Calculator;

import java.util.ArrayList;
import java.util.List;

public class ParsingService {

    public void parsing(Calculator calculator, String input) {
        char identifier = parseIdentifier(calculator, input);
        String expression = parseExpression(identifier, input);
        List<Long> operands = extractOperands(calculator, expression);
        calculator.addOperands(operands);
    }

    private char parseIdentifier(Calculator calculator, String input) {
        if(input.matches("^//.\\\\n.*")) {
            calculator.addIdenfitier(input.charAt(2));
            return input.charAt(2);
        }
        return '\0';
    }

    private String parseExpression(char identifier, String input) {
        if(identifier != '\0') {
            return input.substring(5);
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
            e.printStackTrace();
            throw new IllegalArgumentException("식에는 숫자와 구분자만 입력 가능합니다.");
        }

        return operands;
    }

}
