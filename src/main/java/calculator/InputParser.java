package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    public static ParsedInput parse(String input){
        String delimiter = DEFAULT_DELIMITERS;
        String numbersString = input;

        if (input.startsWith("//")) {
           Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
           if(matcher.find()){
               delimiter = Pattern.quote(matcher.group(1));
               numbersString = matcher.group(2);
           }
        }

        String[] tokens = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for(String token : tokens){
            int number = parseInt(token.trim());
            NumberValidator.validate(number);
            number.add(number);
        }

        return new ParsedInput(numbers);
    }

    private int parseNumber(String token){
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
        }
    }
}
