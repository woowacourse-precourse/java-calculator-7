package calculator.util.parser;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.constant.Constants.*;

public class NumberParser {
    public static String[] parse(String input) {
        String delimiter = DEFAULT_DELIMITER_PATTERN; // 기본 구분자 설정
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);  // 커스텀 구분자
            input = matcher.group(2);       // 숫자 부분
        }

        return input.split("[,:" + delimiter + "]"); // 구분자로 분할
    }
}
