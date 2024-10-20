package calculator.model;

import calculator.util.ErrorMessage;
import calculator.util.Message;
import calculator.util.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final int DELIMITER_GROUP = 1;
    private final int ARITHMETIC_GROUP = 2;

    private final String input;

    public InputData(String input) {
        this.input = input;
    }

    public boolean isDelimiter(){
        Matcher delimiterMatcher = getMatcher();

        return delimiterMatcher.matches();
    }

    public String convertDelimiterPart(){
        Matcher delimiterMatcher = getMatcher();
        String delimiter = Message.BLANK.getSentence();

        if(delimiterMatcher.matches()){
            delimiter = delimiterMatcher.group(DELIMITER_GROUP);
        }
        return delimiter;
    }

    public String convertCalculatorPart() {
        Matcher calculatorMatcher = getMatcher();
        String calculator = input;

        if(calculatorMatcher.matches()){
            calculator = calculatorMatcher.group(ARITHMETIC_GROUP);
        }

        return calculator;
    }

    private Matcher getMatcher(){
        Pattern pattern = Pattern.compile(Regex.DELIMITER_GROUP_FORMAT.getRegex());
        return pattern.matcher(input);
    }
}
