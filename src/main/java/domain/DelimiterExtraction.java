package domain;

import java.util.regex.*;

public class DelimiterExtraction {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public String[] Extraction(String input){
        Matcher matcher = CUSTOM_DELIMITER.matcher(input);

        // 커스텀 구분자일 때
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(Pattern.quote(customDelimiter)); // 커스텀 구분자로 분리
        }
        // 구분자가 없는 경우 → 숫자만 존재할 때
        if(input.matches("[0-9]+")){
            return new String[]{input};
        }

        return input.split(DEFAULT_DELIMITER);
    }
}
