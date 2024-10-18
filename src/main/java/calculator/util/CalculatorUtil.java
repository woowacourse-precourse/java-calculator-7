package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorUtil {
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.*?)\\n";

    private CalculatorUtil() {};

    public static List<String> extractDelimiter(String inputValue) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(inputValue);
        List<String> delimiters = new ArrayList<>();

        if (inputValue.contains(",")) delimiters.add(",");

        if (inputValue.contains(":")) delimiters.add(":");

        if (matcher.find()) {
            String[] customDelimiters = matcher.group(1).split("\\|");

            for (String delimiter : customDelimiters) {
                delimiters.add(delimiter.trim());
            }
        }

        return delimiters;
    }

    public static List<Integer> splitByDelimiters(List<String> delimiters, String inputValue) {
        String combinedDelimiters = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        return Arrays.stream(inputValue.split(combinedDelimiters))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String formattingString(String inputValue) {
        return inputValue.replaceAll(CUSTOM_DELIMITER_REGEX, "");
    }

    public static Boolean isOnlyOneCustomDeclare(String inputValue) {
        // TODO : 커스텀 구분자 선언부가 1개만 존재하는 지 확인합니다.

        String formattingString = formattingString(inputValue);

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(formattingString);

        return !matcher.find();
    }


    public static Boolean isContainInvalidChar(String inputValue) {

        // TODO : 추출한 delimiter 외 다른 '문자' 또는 '공백'을 포함하는 지 확인합니다.

        List<String> delimiters = extractDelimiter(inputValue);

        String formattingString = formattingString(inputValue);

        for (String delimiter : delimiters) {
            formattingString = formattingString.replaceAll(Pattern.quote(delimiter), "");
        }

        for (char s : formattingString.toCharArray()) {
            if (!Character.isDigit(s)) return true;
        }
        return false;
    }
}
