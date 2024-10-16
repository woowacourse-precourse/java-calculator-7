package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static final String CUSTOM_DELIMITER_EXTRACT_REGEX = "(?<=\\/\\/)([\\w\\*\\@\\$\\!\\%\\*\\#\\?\\&\\;\\~\\^\\{\\}\\(\\)\\<\\>\\-\\+\\[\\]\\'\\\"\\,\\.\\\\]*)(?=\\\\n)";
    public static final Pattern COMPILED_PATTERN = Pattern.compile(CUSTOM_DELIMITER_EXTRACT_REGEX);
    public static final String DEFAULT_DELIMITER_AREA_REGEX = "(:(?=\\d+))|(,(?=\\d+))|(\\/\\/([\\w\\*\\@\\$\\!\\%\\*\\#\\?\\&\\;\\~\\^\\{\\}\\(\\)\\<\\>\\-\\+\\[\\]\\'\\\"\\,\\.\\\\]*)\\\\n)";
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";
    public static final String CONTAINING_ALL_START_REGEX = "^.*(";
    public static final String CONTAINING_ALL_END_REGEX = ").*";
    public static final String POSITIVE_NUMBER_REGEX = "^(\\+?)\\d*$";

    public static void main(String[] args) {
        // 0. 입력한다.
        String input = Console.readLine();

        // 1.커스텀 구분자를 등록한다.
        Matcher matcher = COMPILED_PATTERN.matcher(input);
        StringBuilder delimiterAreaRegex = new StringBuilder(DEFAULT_DELIMITER_AREA_REGEX);
        StringBuilder existingDelimiterRegex = new StringBuilder(DEFAULT_DELIMITER_REGEX);
        while (matcher.find()) {
            String extractedDelimiter = matcher.group();
            checkDelimiter(extractedDelimiter, existingDelimiterRegex);

            extractedDelimiter = escapeMetaCharacter(extractedDelimiter);
            delimiterAreaRegex.append('|').append(extractedDelimiter);
            existingDelimiterRegex.append('|').append(extractedDelimiter);
        }

        //2. 구분자를 기준으로 숫자를 추출한다.
        String[] splitedByRegex = input.split(delimiterAreaRegex.toString());
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(splitedByRegex)
                    .filter(str -> str.length() > 0)
                    .map(Integer::parseInt)
                    .map(Application::getPositiveNumber)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
        }

        // 3. 구한 숫자들을 더한다.
        int sum = 0;
        for (Integer number : numbers) {
            sum = addSafe(sum, number);
        }
        System.out.println("결과 : " + sum);
    }

    private static void checkDelimiter(String delimiter, StringBuilder existingDelimiterRegex) {
        if (delimiter.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("구분자는 숫자로만 이루어질 수 없습니다. 문자를 포함하세요.");
        }

        String totalRegex = CONTAINING_ALL_START_REGEX + existingDelimiterRegex + CONTAINING_ALL_END_REGEX;
        if (delimiter.matches(totalRegex)) {
            throw new IllegalArgumentException("구분자는 다른 구분자를 포함할 수 없습니다.");
        }
    }

    private static int getPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닙니다.");
        }

        return number;
    }

    private static String escapeMetaCharacter(String delimiter) {
        StringBuilder metaCharacter = new StringBuilder();
        for (char c : delimiter.toCharArray()) {
            if (c == '?' || c == '*' || c == '+' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{'
                    || c == '}') {
                metaCharacter.append("\\").append(c);
            } else {
                metaCharacter.append(c);
            }
        }

        return metaCharacter.toString();
    }

    private static int addSafe(int number1, int number2) {
        if (number1 > 0 && number2 > Integer.MAX_VALUE - number1) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        if (number2 > 0 && number1 > Integer.MAX_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        return number1 + number2;
    }
}
