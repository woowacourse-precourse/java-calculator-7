package calculator;

import util.Constants;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StringCalculator {
    // 문자열에 적힌 수를 합산하는 메서드
    public static int calculateSum(String string){
        String[] parsedStrings = parseString(string);
        return sumParsedString(parsedStrings[1], parsedStrings[0]);
    }

    // 문자열에서 커스텀구분자와 수가 포함된 문자열을 분리하는 메서드
    public static String[] parseString(String string){
        String newDelimiter = Constants.DEFAULT_DELIMITERS;
        String numberString = string;

        if(string.contains("//")){
            newDelimiter += "|" + Pattern.quote(string.substring(2, 3));
            numberString = string.substring(5);
        }

        return new String[]{newDelimiter, numberString};
    }

    // 수가 포함된 문자열에서 숫자 값을 뽑아 모두 더하는 메서드
    public static int sumParsedString(String numberString, String delimiter){
        StringTokenizer tokenizer = new StringTokenizer(numberString, delimiter);
        int sum = 0;
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            int num = Integer.parseInt(token);

            sum += num;
        }

        return sum;
    }
}
