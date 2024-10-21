package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    // 문자열을 구분자로 분리하는 함수
    public static String[] splitString(String subString, String customDelimiter) {
        // 결과를 담을 리스트
        List<String> resultList = new ArrayList<>();

        // customDelimiter가 비어있지 않은 경우
        if (!customDelimiter.isEmpty()) {
            // 먼저 customDelimiter로 분리
            String[] separatedStrings = subString.split(customDelimiter);

            // 각 요소에서 :나 ,로 추가 분리
            for (String str : separatedStrings) {
                String[] furtherSeparated = str.trim().split("[,:]");
                resultList.addAll(Arrays.asList(furtherSeparated)); // 리스트에 추가
            }
        }

        // List를 배열로 변환하여 반환
        return resultList.toArray(new String[0]);
    }

    public static String[] splitString(String subString) {
        // customDelimiter가 비어있으면 :,로 분리만 수행
        String[] separatedStrings = subString.trim().split("[,:]");
        return separatedStrings;
    }


}
