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

        return appropriateDelimiter(matcher);
    }

    // 커스텀 구분자에 들어가는 특수한 케이스들에 대해 백슬래시를 더해주기 위한 메소드
    public static String appropriateDelimiter(Matcher matcher) {
        String appropriateDelimiter = "";

        // 그냥 넣으면 에러가 발생하는 특수 케이스들
        String specialChars = "\\[]{}()|^*$?+";

        // matcher.group(2)는 커스텀 구분자를 의미함
        char[] charArray = matcher.group(2).toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            // 만약 특수 케이스에 해당 한다면 앞에 백슬래시를 더해 제대로 인식하게 함
            if (specialChars.indexOf(charArray[i]) != -1) {
                appropriateDelimiter += "\\" + charArray[i];
            }
            // 그 이외의 경우엔 그냥 더한다
            else {
                appropriateDelimiter += charArray[i];
            }
        }

        return appropriateDelimiter;
    }
}
