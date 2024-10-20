package calculator.domain;

import java.util.ArrayList;
import java.util.List;


public class InputParser {
    private final Delimiters delimiters;

    public InputParser(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public List<Double> parse(String input){
        List<Double> numbers = new ArrayList<>();

        String delimiterRegex = getDelimiterRegex(input);
        input = removeDelimiterDefenition(input);

        for(String number : input.split(delimiterRegex)) {
            validateNumber(number);
            numbers.add(Double.parseDouble(number));
        }
        return numbers;
    }

    private String getDelimiterRegex(String input){
        StringBuilder delimiterRegex = new StringBuilder();
        for(String delimiter : delimiters.getAllDelimiters(input)){
            delimiterRegex.append(delimiter);
            delimiterRegex.append("|");
        }
        String result = delimiterRegex.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }

    private void validateNumber(String number){
        if(!isNumeric(number)){
            throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
        }

        if(!isPositive(number)){
            throw new IllegalArgumentException("피연산자가 양수가 아닙니다.");
        }
    }

    private boolean isNumeric(String number){
        try{
            Double.parseDouble(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private boolean isPositive(String number){
        return Double.parseDouble(number) > 0;
    }

    private String removeDelimiterDefenition(String input){
        if(input.startsWith("//")){
            return input.substring(5);
        }
        return input;
    }
}

