package calculator;

import java.util.regex.Pattern;

public class Distiniction {
    public static String[] splitInput(String input) {
        String delimiter = "[,:]"; // 기본 구분자: 쉼표와 콜론

        // 커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex); // "//"과 "\n" 사이의 문자열
                System.out.println("커스텀 구분자: " + customDelimiter); // 커스텀 구분자 출력
                delimiter = Pattern.quote(customDelimiter); // 커스텀 구분자를 정규식으로 처리
                input = input.substring(delimiterEndIndex + 1); // 숫자 부분만 남김
            }
        }

        // 분리된 숫자 문자열 확인
        System.out.println("분리된 문자열: " + input);

        // 기본 구분자와 커스텀 구분자를 모두 고려하여 분리
        return input.split(delimiter); // 구분자를 기준으로 분리하여 반환
    }
}
