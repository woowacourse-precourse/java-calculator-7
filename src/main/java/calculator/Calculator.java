package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\\\\n(.*)";
    private static final String BASIC_DELIMITER = ",|:";
    private String customDelimiter;
    private long result;

    public void calculate(){
        Regex regex = new Regex();
        inputExpression(regex);
        extractNumbers(regex);
        circulateResult(regex);
    }

    private void circulateResult(Regex regex){
        result = regex.sumNumbers();
    }

    private void extractNumbers(Regex regex) {
        String delimiter = BASIC_DELIMITER;

        if(customDelimiter != null) {
            delimiter = delimiter + "|" + customDelimiter;
        }

        regex.setNumbers(delimiter);
    }

    public void inputExpression(Regex regex) {
        String expression;
        String input = Console.readLine();
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            customDelimiter = matcher.group(1);
            expression = matcher.group(2);
            validateNotDigit();
        } else {
            expression = input;
        }

        Console.close();
        regex.setExpression(expression);
    }

    private void validateNotDigit() {
        if(Character.isDigit(customDelimiter.charAt(0))){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
