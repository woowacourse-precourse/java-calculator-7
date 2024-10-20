package calculator.model;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String input){

        List <String> tokens = splitString(input);

        return tokens.stream().mapToInt(this::parseInt).sum();
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
            //TODO 오류 메시지 출력
            return 0;
        }
    }
}
