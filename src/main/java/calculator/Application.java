package calculator;

import static calculator.Constants.CUSTOM_DELIMITER_PREFIX;
import static calculator.Constants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.Constants.DEFAULT_DELIMITER;
import static calculator.Constants.DEFAULT_DELIMITER_PATTERN;
import static calculator.Constants.ERROR_MESSAGE;
import static calculator.Constants.INPUT_MESSAGE;
import static calculator.Constants.MAXIMUM_NUMBER;
import static calculator.Constants.OUTPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    private static String inputString;

    public static void main(String[] args) {
        // 문자열 입력 받기
        inputString = getInputString();
        // 커스텀 문자 추출
        List<String> customDelimiters = extractCustomDelimiters();
        // 기본 구분자, 커스텀 구분자 총합한 패턴 가져오기
        String delimiterPattern = getDelimiterPattern(customDelimiters);
        // 받은 문자열 분리하여 숫자로 저장
        List<Long> values = getValues(delimiterPattern);
        // 모든 수 더하고 값 출력
        printResult(values);
    }

    private static String getInputString() {
        System.out.println(INPUT_MESSAGE);
        String inputString = Console.readLine();
        return inputString;
    }

    private static List<String> extractCustomDelimiters() {
        List<String> customDelimiters = new ArrayList<>();

        // 3. 커스텀 구분자 저장
        while (inputString.startsWith(CUSTOM_DELIMITER_PREFIX)) { //  "//"로 시작하는지 확인 -> 무조건 뒤에 "\n"이 있어야함
            int i = getIndexOfCustomDelimiterSuffix();

            String customDelimiterSection = extractCustomDelimiterSection(i);
            removeCustomDelimiterFromInput(i);    //첫 번째 커스텀 구분자 지정 부분 삭제

            extractAndValidateCustomDelimiters(customDelimiterSection, customDelimiters);
        }
        return customDelimiters;
    }

    private static int getIndexOfCustomDelimiterSuffix() {
        int i = inputString.indexOf(CUSTOM_DELIMITER_SUFFIX); //    "\n"이 있는 위치를 찾고 그 사이를 분리
        if (i == -1)
            throw new IllegalArgumentException(ERROR_MESSAGE);
        return i;
    }

    private static String extractCustomDelimiterSection(int i) {
        String subString = inputString.substring(CUSTOM_DELIMITER_PREFIX.length(), i);
        return subString;
    }

    private static void removeCustomDelimiterFromInput(int i) {
        inputString = inputString.substring(i + CUSTOM_DELIMITER_SUFFIX.length(), inputString.length());
    }

    private static void extractAndValidateCustomDelimiters(String customDelimiterSection, List<String> customDelimiters) {
        String[] splitByDefaultDelimiter = customDelimiterSection.split(DEFAULT_DELIMITER_PATTERN);
        for (String customDelimiter : splitByDefaultDelimiter) {
            validateRange(customDelimiter);
            validateFormatAndAddCustomDelimiter(customDelimiters, customDelimiter);
        }
    }

    private static void validateRange(String customDelimiter) {
        if (customDelimiter.length() > 1)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private static void validateFormatAndAddCustomDelimiter(List<String> customDelimiters, String customDelimiter) {
        if (customDelimiter.length() == 1) {
            if (Character.isLetterOrDigit(customDelimiter.charAt(0)))
                throw new IllegalArgumentException(ERROR_MESSAGE);

            if (!customDelimiters.contains(customDelimiter) &&
                    customDelimiter.charAt(0) != DEFAULT_DELIMITER.get(0).charAt(0) &&
                    customDelimiter.charAt(0) != DEFAULT_DELIMITER.get(1).charAt(0))
                customDelimiters.add(customDelimiter);
        }
    }

    private static String getDelimiterPattern(List<String> customDelimiters) {
        String customDelimiterPattern = null;

        customDelimiterPattern = getCustomDelimiterPattern(customDelimiters, customDelimiterPattern);

        return getDelimiterPattern(customDelimiterPattern);
    }

    private static String getCustomDelimiterPattern(List<String> customDelimiters, String customDelimiterPattern) {
        if (!customDelimiters.isEmpty()) {
            customDelimiterPattern = customDelimiters.stream()
                    .map(Pattern::quote)
                    .collect(Collectors.joining("|"));
        }
        return customDelimiterPattern;
    }

    private static String getDelimiterPattern(String customDelimiterPattern) {
        String delimiterPattern = null;

        if (customDelimiterPattern == null)
            delimiterPattern = DEFAULT_DELIMITER_PATTERN;
        else if (customDelimiterPattern != null)
            delimiterPattern = DEFAULT_DELIMITER_PATTERN + "|" + customDelimiterPattern;
        return delimiterPattern;
    }

    private static List<Long> getValues(String delimiterPattern) {
        List<Long> values = new ArrayList<>();

        String[] stringValues = inputString.split(delimiterPattern);
        for (String stringValue : stringValues) {
            long longValue = getLongValue(stringValue);
            validateLongValue(longValue);
            values.add(longValue);
        }
        return values;
    }

    private static void validateLongValue(long longValue) {
        if (longValue > MAXIMUM_NUMBER)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        if (longValue < 0)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private static long getLongValue(String stringValue) {
        long longValue;
        try {
            longValue = Long.parseLong(stringValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return longValue;
    }


    private static void printResult(List<Long> values) {
        Long result = values.stream().mapToLong(Long::longValue).sum();
        if (result < 0)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        System.out.println(OUTPUT_MESSAGE + result);
    }


}
