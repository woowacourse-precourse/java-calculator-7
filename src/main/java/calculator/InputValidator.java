package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\\\\n*";

    private Matcher hasCustomDelimiter(String input){ // "^//(.)\\\\n(.*)" 패턴이 있을 시 Matcher반환.
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return matcher;
        }
        return null;
    }

    public String[] validateAndPrepareInput(String input){ // 사용자 입력 유효성 검사 및 전처리
        Matcher matcher = hasCustomDelimiter(input);
        String delimiter = ",|:"; // 기본 구분자
        if(matcher != null){ //커스텀 구분자가 있을시
            delimiter += "|" + matcher.group(1); // 커스텀 구분자 추가
            input = input.substring(5); // 커스텀 구분자 패턴 제거
            validatePattern(input, delimiter); // 유효성 검사
            return new String[]{input,delimiter.replace("|","")};
        }
        validatePattern(input, delimiter); // 유효성 검사
        return new String[]{input,delimiter.replace("|","")};
    }

    private void validatePattern(String input, String delimiter){ // 입력 패턴 유효성 검사
        String pattern = "^[0-9]+([" + delimiter + "][0-9]+)*$";
        if(!input.matches(pattern)){ // 유효하지 않을시 예외 발생
            throw new IllegalArgumentException();
        }
    }

    public boolean inputIsEmpty(String input){ // 사용자 입력이 "" 인지 판단
        return input == null || input.trim().isEmpty();
    }
}
