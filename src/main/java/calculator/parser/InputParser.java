package calculator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\\n";

    public String[] parseInput(String input) {
        if (input.startsWith(DELIMITER_PREFIX)) {
            // TODO : 커스텀 구분자를 추출할 수 없는 경우('\n' 부재) 예외 발생

            String[] parts = input.split(Pattern.quote(DELIMITER_SUFFIX), 2);
            return new String[]{parts[0], parts[1]};
        }

        return new String[]{null, input};
    }

    public Character parseCustomDelimiterPart(String customDelimiterPart) {
        String regex = Pattern.quote(DELIMITER_PREFIX) + "(.*)";
        return extractCustomDelimiter(customDelimiterPart, regex);
    }

    private Character extractCustomDelimiter(String customDelimiterPart, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(customDelimiterPart);

        if (!matcher.find()) {
            // TODO : 알 수 없는 오류로 인한 구분자 추출 예외 발생
            System.out.println("알 수 없는 오류로 인한 구분자 추출 예외 발생");
        }

        String findCustomDelimiterString = matcher.group(1);

        if (findCustomDelimiterString.length() != 1) {
            // TODO : 커스텀 구분자가 문자가 아닌 문자열인 경우 예외 발생
            System.out.println("커스텀 구분자가 문자가 아닌 문자열 혹은 공백인 경우 예외 발생");
        }

        Character findCustomDelimiter = findCustomDelimiterString.charAt(0);

        if (Character.isDigit(findCustomDelimiter)) {
            // TODO : 커스텀 구분자가 숫자인 경우 예외 발생
            System.out.println("커스텀 구분자가 숫자인 경우 예외 발생");
        }

        return findCustomDelimiter;
    }
}
