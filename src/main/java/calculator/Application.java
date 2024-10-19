package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static final String DELIMITER_PATTERN = "//(.)\\\\n(.*)";
    public static void main(String[] args) {
        String input = Console.readLine(); //문자열 입력받기.
    }

    public static String extractDelimiter(String input){ // "//(.)\\\\n(.*)" 패턴에서 구분자 추출하여 반환.
        Pattern pattern = Pattern.compile(DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }
}
