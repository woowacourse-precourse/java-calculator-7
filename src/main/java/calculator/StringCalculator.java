package calculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public int calculate(String input) {
        Character customDelimiter = null;

        //커스텀 구분자 추출
        if (input.startsWith("//") && input.contains("\\n")) { //커스텀 구분자 존재 시
            String customDelimiterStr = input.substring(2, input.lastIndexOf("\\n"));

            if (customDelimiterStr.length() != 1) { //커스텀 구분자의 길이가 1인지 확인
                throw new IllegalArgumentException();
            }

            customDelimiter = customDelimiterStr.charAt(0);
        }

        //계산 문자열 구분
        String calculateStr = input;
        if (customDelimiter != null) {
            calculateStr = input.substring(input.lastIndexOf("\\n") + 2);
        }

        //계산 문자열을 구분자로 분리
        String splitRegex = ":|,";
        if (customDelimiter != null) {
            splitRegex = splitRegex + "|" + customDelimiter;
        }

        String[] parsedCalculateStr = calculateStr.split(splitRegex);

        //정수로 변환 및 계산
        for (String str : parsedCalculateStr) {
            int num;
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (!str.equals("")) { //입력 없을 시 0 / 구분자와 구분자 사이 입력이 없을 시는? TODO
                    throw new IllegalArgumentException("구분자와 양수 이외 다른 문자는 입력x");
                }

                num = 0;
            }

            if (num < 0) {
                throw new IllegalArgumentException("양수만 입력");
            }
        }

        return 0; //TODO
    }
}
