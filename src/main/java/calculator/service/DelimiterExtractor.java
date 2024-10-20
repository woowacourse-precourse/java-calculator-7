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

    // 커스텀 구분자에 \가 포함된 경우 적절한 \개수를 설정해주기 위한 메소드
    public static String appropriateDelimiter(Matcher matcher) {
        String appropriateDelimiter = "";
        // matcher.group(2)는 커스텀 구분자를 의미함
        char[] charArray = matcher.group(2).toCharArray();

        // 만약 커스텀 구분자에 \가 있다면 \\\\를 더해, 문자열에서 \\으로 나타날 수 있도록 함
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == '\\'){
                appropriateDelimiter += "\\\\";
            }
            // \가 아닌 경우는 그냥 더한다
            else{
                appropriateDelimiter += charArray[i];
            }
        }

        return appropriateDelimiter;
    }
}
