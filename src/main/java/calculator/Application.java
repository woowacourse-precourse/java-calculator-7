package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static final String DELIMITER_PATTERN = "//(.)\\\\n(.*)";
    public static void main(String[] args) {
        String input = Console.readLine(); //문자열 입력받기.
        String[] numbers = splitNumbers(input); //구분자로 구분한 후 추출한 숫자
    }

    public static String extractDelimiter(String input){ // "//(.)\\\\n(.*)" 패턴에서 구분자 추출하여 반환.
        Pattern pattern = Pattern.compile(DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public static String[] splitNumbers(String input){ // 구분자를 기준을 문자로된 숫자 추출 후 반환.
        String delimiters = ",:"; // 기본 구분자
        String customDelimiter = extractDelimiter(input); // 커스텀 구분자 추출
        if(customDelimiter != null){ // 커스텀 구분자 존재시 기본 구분자에 추가
            delimiters += customDelimiter;
            input = input.substring(5); //커스텀 구분자 패턴 삭제
        }
        return input.split("[" + delimiters + "]");
    }
}