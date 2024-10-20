package calculator.model;

import calculator.util.DelimiterParser;
import calculator.util.NumberParser;

public class AdditionCommand { ;
    private final String customDelimiter;
    private final NumberParser numberParser = new NumberParser();
    private final DelimiterParser delimiterParser = new DelimiterParser();
    private Number[] numbers;
    public AdditionCommand(String input){
        validateInput(input);
        customDelimiter = delimiterParser.findCustomDelimiter(input).orElse("");

        if (!customDelimiter.isBlank()) {
            input = delimiterParser.removeCustomDelimiter(input);
        }

        numbers = numberParser.parse(input,customDelimiter);
    }

    public Double exec(){
        double result = 0;
        for (Number number : numbers){
            result += number.getNumber();
        }
        return result;
    }
    private void validateInput(String input){
        if (isNull(input)){
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닙니다.");
        }
    }

    private boolean isNull(String input){
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }
}
