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

        // 커스텀 구분자에 들어가는 특수한 케이스들에 대해 백슬래시를 더해준다
        for(int i = 0; i < charArray.length; i++){
            // \가 들어가는 경우 앞에 백슬래시를 하나씩 더해준다
            if(charArray[i] == '\\'){
                appropriateDelimiter += "\\\\";
            }
            // [ 또는 ]가 들어가는 경우 앞에 백슬래시를 더해준다
            else if(charArray[i] == '[' || charArray[i] == ']'){
                appropriateDelimiter += "\\" + charArray[i];
            }
            // 이외의 경우는 그냥 더한다
            else{
                appropriateDelimiter += charArray[i];
            }
        }

        return appropriateDelimiter;
    }
}
