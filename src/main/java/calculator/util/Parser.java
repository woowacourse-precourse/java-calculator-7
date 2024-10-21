package calculator.util;

import calculator.domain.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public Calculator parse(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);
            if(matcher.matches()){
                String customDelimiter = matcher.group(1);
                delimiter =  DEFAULT_DELIMITERS + "|" + customDelimiter;
                numbers = matcher.group(2);
            }else{
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        String[] tokens = numbers.split(delimiter);
        return new Calculator(delimiter, tokens);
    }
}
