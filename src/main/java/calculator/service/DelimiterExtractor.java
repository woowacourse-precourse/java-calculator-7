package calculator.service;

import calculator.exception.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 커스텀 구분자를 추출하기 위한 클래스
public class DelimiterExtractor {
    // 커스텀 구분자를 추출하기 위한 정규식
    private static final String CUSTOM_DELIMITER_PATTERN = "(//)(.*)(\\\\n)";

    // 커스텀 구분자를 추출해서 반환하는 메소드
    public static String extractDelimiter(String userInput) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(userInput);

        // 만약 커스텀 구분자 입력 형식과 맞지 않는다면 예외 발생
        if(!matcher.find()){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_CUSTOM_DELIMITER_PATTERN.getMessage());
        }

        return matcher.group(2);

    }
}
