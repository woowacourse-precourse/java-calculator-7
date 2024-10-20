package calculator.domain;

import java.util.ArrayList;
import java.util.List;

import static calculator.constant.DelimiterConstants.CUSTOM_DELIMITER_DEFINITION_SIZE;
import static calculator.constant.DelimiterConstants.CUSTOM_DELIMITER_START_SEPARATOR;
import static calculator.constant.ErrorMessages.*;


public class InputParser {
    private final Delimiters delimiters;

    public InputParser(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public List<Double> parse(String input){
        List<Double> numbers = new ArrayList<>();

        String delimiterRegex = delimiters.getDelimiterRegex(input);
        input = removeDelimiterDefinition(input);

        for(String number : input.split(delimiterRegex)) {
            validateNumber(number);
            numbers.add(Double.parseDouble(number));
        }
        return numbers;
    }

    private void validateNumber(String number){
        if(!isNumeric(number)){
            throw new IllegalArgumentException(OPERAND_NOT_NUMBER);
        }

        if(!isPositive(number)){
            throw new IllegalArgumentException(OPERAND_NOT_POSITIVE);
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

    private String removeDelimiterDefinition(String input){
        if(input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR)){
            return input.substring(CUSTOM_DELIMITER_DEFINITION_SIZE);
        }
        return input;
    }
}

