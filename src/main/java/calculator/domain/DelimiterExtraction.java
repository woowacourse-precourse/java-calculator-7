package calculator.domain;

import java.util.regex.*;

public class DelimiterExtraction {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\\\\n(.*)");

    public String[] Extraction(String input){
        Matcher matcher = CUSTOM_DELIMITER.matcher(input);

        // 커스텀 구분자가 있을 때
        if(matcher.find()){
            String customDelimiter = matcher.group(1); // 사용자 정의 구분자 추출
            String numbers = matcher.group(2); // 숫자 부분 추출

            String combinedDelimiter = Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITER;
            return numbers.split(combinedDelimiter); // 커스텀 구분자로 분리
        }
        // 구분자가 없는 경우 → 숫자만 존재할 때
        if(input.matches("[0-9]+")){
            return new String[]{input};
        }

        return input.split(DEFAULT_DELIMITER);
    }
}
