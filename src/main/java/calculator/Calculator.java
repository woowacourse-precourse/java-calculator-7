package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
     public int add(String input) {
         if (input == null || input.trim().isEmpty()) {
             return 0;  // 빈 문자열일 경우 0 반환
         }
         // 기본 구분자
         String delimiter = ",|:";

         //커스텀 구분자
         if (input.startsWith("//")) {
             Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
             if (matcher.find()) {
                 delimiter = Pattern.quote(matcher.group(1));
                 input = matcher.group(2);
             }
             else {
                 throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
             }
         }

         String[] tokens = input.split(delimiter);
         return sumTokens(tokens);

     }

    // 분리된 숫자 더하기
    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {  // 빈 문자열은 무시
                continue;
            }
            int number = parseNumber(token);
            sum += number;
        }
        return sum;
    }

    // 문자열 숫자로 변환
    private int parseNumber(String token) {
       return Integer.parseInt(token.trim());
    }
}

