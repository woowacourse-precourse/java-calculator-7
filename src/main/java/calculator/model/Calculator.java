package calculator.model;

import calculator.message.Message;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String input){

        if(input.isEmpty()) return 0; //"" 일 경우 0 반환

        List <String> tokens = splitString(input);

        return tokens.stream()
                .mapToInt(this::parseInt)
                .sum();
    }

    private List<String> splitString(String input){

        String delimeter = ",|:"; //기본 구문자 지정

        if(input.startsWith("//") && input.indexOf("\\n")== 3){
            String customDelimeter = input.substring(2,3);
            delimeter += "|" + customDelimeter;
        }

        String [] inputTokens = input.split(delimeter);
        return Arrays.asList(inputTokens);
    }

    private int parseInt(String token){
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ILLEGAL_ARGUMENT_ERROR.toString());
        }
    }
}
