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
        Matcher delimiterMatcher = getMatcher(Regex.DELIMITER_GROUP_FORMAT.getRegex());

        return delimiterMatcher.matches();
    }

    public String convertDelimiterPart(){
        Matcher delimiterMatcher = getMatcher(Regex.DELIMITER_GROUP_FORMAT.getRegex());
        String delimiter = Message.BLANK.getSentence();

        if(delimiterMatcher.matches()){
            delimiter = delimiterMatcher.group(DELIMITER_GROUP);
        }
        return delimiter;
    }

    public String convertCalculatorPart() {
        Matcher calculatorMatcher = getMatcher(Regex.DELIMITER_GROUP_FORMAT.getRegex());
        String calculator = input;

        if(calculatorMatcher.matches()){
            calculator = calculatorMatcher.group(ARITHMETIC_GROUP);
        }

        if(calculator.isEmpty()){
            calculator = Message.DEFAULT_NUMBER.getSentence();
        }

        return calculator;
    }

    private Matcher getMatcher(String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
