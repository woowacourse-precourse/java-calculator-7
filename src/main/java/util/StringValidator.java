package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    // 문자열 검증 메서드
    public static void stringValidate(String inputString) throws IllegalArgumentException{
       checkNull(inputString);
       checkNegativeValue(inputString);
       if(inputString.contains("//")){
           validateCustomDelimiter(inputString);
       }else validateDelimiters(inputString, Constants.DEFAULT_DELIMITERS);
    }

    // 입력 문자열이 null인 경우
    public static void checkNull(String inputString){
        if(inputString == null){
            throw new IllegalArgumentException("입력한 문자열이 null 입니다.");
        }
    }

    // 문자열 앞부분의 "//"와 "\n" 사이에 커스텀 구분자를 지정하지 않은 경우
    // "//"와 "\n" 사이에 2개 이상의 문자가 포함되어 있는 경우
    public static void validateCustomDelimiter(String inputString){
        Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(inputString);
        if(matcher.matches()){
            String customDelimiter = matcher.group(1);
            String otherText = matcher.group(2);

            String newDelimiter = Constants.DEFAULT_DELIMITERS + "|"+customDelimiter;
            validateDelimiters(otherText, newDelimiter);

        }else throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
    }

    // 기본 및 지정된 커스텀 구분자와 숫자 이외의 문자가 포함된 경우
    public static void validateDelimiters(String inputString, String delimiters){
        String[] splitTexts = delimiters.split(delimiters);

        for(String text : splitTexts){
            if(!text.matches("\\d+")) throw new IllegalArgumentException("지정하지 않은 구분자가 포함되어 있습니다.");
        }
    }
    // 음수가 입력된 경우
    public static void checkNegativeValue(String inputString){
        if(inputString.matches(".*-\\d+.*"))
            throw new IllegalArgumentException("입력 값에 음수가 포함되어 있습니다.");
    }
}
