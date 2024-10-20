package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public boolean validateCustomSeparator(String input){
        // 정규식으로 커스텀 구분자 사용을 탐지
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public String[] extractCustomSeparatorAndInputString(String input){
        // 정규식으로 커스텀 구분자와 나머지 입력을 나누어 반환
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        String[] ret = new String[2];
        if (matcher.find()) {
            ret[0] = matcher.group(1);
            ret[1] = matcher.group(2);
            return ret;
        }
        return null;
    }

    public boolean containsInvalidCharacters(String input, String... customSep) {
        // 입력 문자열에 허용되지 않은 문자가 포함되어 있는지 체크한다.
        String regex = "0-9:,";

        if (customSep.length > 0) {
            String sep = customSep[0];
            if ("+*?[](){}|.^$".contains(sep)) {
                /*
                 * 자바에서 \\는 정규식에서 \로 인식된다.
                 * 정규식에서 \\를 만들어야되니까
                 * 자바에서 \\\\를 추가
                 */
                sep = "\\\\" + sep;
            }
            regex += sep;
        }

        regex = ".*[^" + regex + "].*";
        return input.matches(regex);
    }

    public boolean startAndEndWithNumber(String input){
        // 입력 문자열의 시작과 끝이 숫자인지 탐지한다.
        return input.matches("^[0-9](.*[0-9])?$");
    }
}
