package calculator.model;

import calculator.util.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final String input;

    public InputData(String input) {
        this.input = input;
        validate();
    }

    public void validate(){
        if (!isDelimiter() && !convertCalculatorPart().matches("^[0-9,:]*$")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError());
        }
    }

    public boolean isDelimiter(){
        Matcher delimiterMatcher = getMatcher("^//(.*)\\\\n(.*)");

        return delimiterMatcher.matches();
    }

    public String convertDelimiterPart(){
        Matcher delimiterMatcher = getMatcher("^//(.*)\\\\n(.*)");
        String delimiter = "";

        if(delimiterMatcher.matches()){
            delimiter = delimiterMatcher.group(1);
        }
        return delimiter;
    }

    public String convertCalculatorPart() {
        Matcher calculatorMatcher = getMatcher("^//(.*)\\\\n(.*)");
        String calculator = input;

        if(calculatorMatcher.matches()){
            calculator = calculatorMatcher.group(2);
        }

        return calculator;
    }

    private Matcher getMatcher(String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
