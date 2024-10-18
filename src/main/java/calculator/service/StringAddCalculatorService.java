package calculator.service;

import calculator.domain.Calculator;
import calculator.util.CustomStringParser;
import calculator.util.StandardStringParser;

public class StringAddCalculatorService {

    public String add(String input) {
        String[] splitStringArr = stringParse(input);

        Calculator calculator = new Calculator();

        return stringAdd(splitStringArr, calculator);
    }

    private String stringAdd(String[] splitStringArr, Calculator calculator) {
        try {
            for (String s : splitStringArr) {
                long num = Long.parseLong(s);
                if (num <= 0) {
                    throw new IllegalArgumentException("양수만 입력 가능합니다");
                }

                calculator.add(num);

            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못되었거나 long 범위를 넘어가는 경우");
        }
        return calculator.getResult();
    }

    private String[] stringParse(String input) {
        if (CustomStringParser.hasCustomSeparator(input)) {
            return CustomStringParser.split(input);
        } else {
            return StandardStringParser.split(input);
        }
    }
}
