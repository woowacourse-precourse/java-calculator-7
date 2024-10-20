package calculator;

import java.util.regex.Pattern;

public class Parser {
    private String delimiter = ",|:";

    public int calculateSentence(String input) {
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            token = token.trim();
            if(!token.isEmpty()) {
                try {
                    int num = parseNumber(token);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닙니다.");
                }
            }
        }
        return sum;

    }
    public int parseNumber(String token) {
        int num = Integer.parseInt(token);
        if(num <0) {
            throw new IllegalArgumentException("양수만 가능합니다.");
        }
        return num;
    }

    public void updateDelimiter(String customDelimiter){
        delimiter = delimiter + "|" + Pattern.quote(customDelimiter);
    }

}

