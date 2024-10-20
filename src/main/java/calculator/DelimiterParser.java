package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    public static String[] parse(String input) {
        // 입력값이 비어("\n") 있으면 숫자 0을 반환하는 메서드
        if (input == null || input.trim().isEmpty()) {
            return new String[] {"0"};
        }
        // 쉼표(,) 또는 콜론(:)을 구분자로 사용
        String delimiter = ",|:";
        
        input = input.replace("\\n", "\n");
        String numbers = input;

        if (input.startsWith("//")) {
            // 사용자 정의 커스텀 구분자 추출 //  "//"와 "\n" 사이에 위치
            Matcher matcher = Pattern.compile("//(.*?)\n(.*)").matcher(input);
            if (matcher.find()) {
                if (matcher.group(1).isEmpty()) {
                    throw new IllegalArgumentException("Delimiter cannot be empty");
                }
                delimiter = Pattern.quote(matcher.group(1)) + "|,|:";
                numbers = matcher.group(2);
            }
        }
        // 구분자로 문자열을 분할하여 반환
        return numbers.split(delimiter);
    }
}