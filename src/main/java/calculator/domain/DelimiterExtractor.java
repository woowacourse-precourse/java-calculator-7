package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DelimiterExtractor {
    static final String CUSTOM_DELIMITER_FORMAT = "//.\\n";
    static int customDelimiterIndex;
    static List<Character> defaultDelimiters = Arrays.asList(',', ':');

    public DelimiterExtractor() {
        // 커스텀 구분자가 나오는 인덱스 번호 탐색
        for(int i = 0 ; i < CUSTOM_DELIMITER_FORMAT.length() ; i ++){
            if(CUSTOM_DELIMITER_FORMAT.charAt(i) == '.') {
                customDelimiterIndex = i;
            }
        }
    }

    public ExtractResult getDelimiters(String input){
        Set<Character> delimiters = new HashSet<>(defaultDelimiters);
        int numberIndex = 0;
        while(numberIndex < input.length()){
            if(!validateFormat(input, numberIndex)) break;
            delimiters.add(input.charAt(numberIndex + customDelimiterIndex));
            numberIndex += CUSTOM_DELIMITER_FORMAT.length();
        }

        numberIndex = Math.min(numberIndex, input.length() - 1);

        return new ExtractResult(input.substring(numberIndex), delimiters);
    }



    // 유효한 형식의 포맷인지 검증
    private boolean validateFormat(String input, int startIdx) {
        if (input.length() - startIdx - 1 < CUSTOM_DELIMITER_FORMAT.length())
            return false;

        for (int i = 0; i < CUSTOM_DELIMITER_FORMAT.length(); i++) {
            if (CUSTOM_DELIMITER_FORMAT.charAt(i) == '.')
                continue;
            if (input.charAt(startIdx + i) != CUSTOM_DELIMITER_FORMAT.charAt(i))
                return false;
        }
        return true;
    }

}
