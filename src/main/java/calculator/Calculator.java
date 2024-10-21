package calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Calculator {

    // 2. 빈 문자열 처리 기능
    public int handleEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 처리
        }
        return -1; // 처리할 값이 있는 경우
    }

    // 3. 커스텀 구분자 처리 기능
    public List<String> getDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(","); // 기본 구분자 포함
        delimiters.add(":");

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");  // 문자 그대로 "\n"을 기준으로 처리
            if (delimiterIndex != -1 && delimiterIndex > 2) {
                String customDelimiter = input.substring(2, delimiterIndex);
                delimiters.add(Pattern.quote(customDelimiter)); // 정규식으로 구분자 처리
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }
        return delimiters;
    }

    // 4. 문자열에서 숫자 추출 기능
    public String[] extractNumbers(String input, List<String> delimiters) {
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            input = input.substring(delimiterIndex + 2); // 구분자 이후의 문자열 추출
        }

        // 여러 구분자를 하나의 정규식으로 결합
        String delimiterRegex = String.join("|", delimiters);
        // 정규식을 기준으로 문자열 분리
        return input.split(delimiterRegex);
    }

}