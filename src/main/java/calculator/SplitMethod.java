package calculator;

import java.util.regex.Pattern;

public class SplitMethod {
    public int split(String input) {

        int sum = 0;

        if (input.startsWith("//")) { // 커스텀 구분자

            int endOfCustom = input.indexOf("\\n");   // '\n'의 시작 위치

            if(endOfCustom == -1) {
                throw new IllegalArgumentException("잘못된 입력겂입니다.");
            }

            String customDelimiter = input.substring(2, endOfCustom); // 커스텀 구분자: '//'과 '\n'의 사이

            String c = Pattern.quote(customDelimiter);

            String seperated = input.substring(endOfCustom+2); // '\n' 뒤에 위치하는 문자열

            String[] tokens = seperated.split(c);

            for (String token : tokens) {
                if (Integer.parseInt(token) < 0) {
                    throw new IllegalArgumentException("잘못된 입력값 입니다.");
                }
                sum += Integer.parseInt(token);
            }
        }
        else {
            if(input.contains(",") || input.contains(":")){ // 기본 구분자

                String[] tokens = input.split("[,:]");

                for (String token : tokens) {
                    if(Integer.parseInt(token) < 0){
                        throw new IllegalArgumentException("잘못된 입력값입니다.");
                    }
                    sum += Integer.parseInt(token);
                }
            }
        }
        return sum;
    }
}
