package calculator.service;

import calculator.domain.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParsingService {

    private Calculator calculator;

    public ParsingService(Calculator calculator) {
        this.calculator = calculator;
    }

    public Calculator parsing(String input) {
        char identifier = parseIdentifier(input);
        String expression = parseExpression(identifier, input);
        System.out.println("identifier: " + identifier);
        System.out.println("expression: " + expression);
        List<Long> operands = extractOperands(expression);
        calculator.addOperands(operands);
        return calculator;
    }

    private char parseIdentifier(String input) {
        if(input.matches("^//.\\n.*")) {
            calculator.addIdenfitier(input.charAt(2));
            return input.charAt(2);
        }
        return '\0';
    }

    private String parseExpression(char identifier, String input) {
        if(identifier != '\0') {
            return input.substring(4, input.length() - 1);
        }
        return input;
    }

    private List<Long> extractOperands(String expression) {
        List<Long> operands = new ArrayList<>();
        String[] numbers = expression.split(calculator.identifiersToString());

        for(String number : numbers) {
            operands.add(Long.parseLong(number));
        }

        return operands;
    }
}
