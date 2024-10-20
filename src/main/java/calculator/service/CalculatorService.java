package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final String DEFAULT_DELIMITERS = ",|:";
    public int add(String input){
        if (input == null || input.isEmpty()){
            return 0;
        }

        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.matches()){
                delimiter = matcher.group(1);
                numbers = matcher.group(2);
            }else{
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        String[] tokens = numbers.split(delimiter);
        return 0;
    }
}
