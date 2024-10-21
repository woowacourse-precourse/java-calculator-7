package calculator.util;

import calculator.domain.Calculator;
import calculator.domain.Tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public Tokens parse(String input) {
        String numbers = input;

        if(input.startsWith("//")){
            return parseCustomDelimiter(input);
        }

        return parseTokens(new Calculator(input));
    }

    private Tokens parseCustomDelimiter(String input) {
        String delimiter =  DEFAULT_DELIMITERS;
        String numbers = input;

        Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);
        if(matcher.matches()){
            String customDelimiter = matcher.group(1);
            delimiter =  DEFAULT_DELIMITERS + "|" + customDelimiter;
            numbers = matcher.group(2);

            return parseTokens(new Calculator(delimiter, numbers));
        }else{
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
    }

    private Tokens parseTokens(Calculator calculator) {
        String[] tokens = calculator.getNumbers().split(calculator.getDelimiter());
        return new Tokens(tokens);
    }
}
