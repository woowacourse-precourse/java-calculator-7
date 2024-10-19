package calculator.extractor;

import static calculator.constants.Constants.CUSTOM_DELIMITER_PREFIX;
import static calculator.constants.Constants.CUSTOM_DELIMITER_SUFFIX;
import static calculator.constants.Constants.DEFAULT_DELIMITER;
import static calculator.constants.Constants.ERROR_MESSAGE;

import calculator.constants.Constants;
import calculator.data.CalculationData;
import calculator.util.PatternFactory;
import java.util.ArrayList;
import java.util.List;

public class DelimiterExtractor {
    public static CalculationData extractCustomDelimiters(String inputString) {
        List<String> customDelimiters = new ArrayList<>();

        while (inputString.startsWith(CUSTOM_DELIMITER_PREFIX)) { //  "//"로 시작한다면 커스텀 구분자 지정 문자열이 있다는 것
            // "\n"이 붙은 곳을 찾고 없다면 입력 오류
            int i = getIndexOfCustomDelimiterSuffix(inputString);

            // 커스텀 구분자 지정 문자열 추출
            String customDelimiterSection = extractCustomDelimiterSection(i, inputString);
            // 커스텀 구분자 검증 후 추출
            extractAndValidateCustomDelimiters(customDelimiterSection, customDelimiters);
            // 추출한 커스텀 구분자 지정 문자열 제외
            inputString = removeCustomDelimiterFromInput(i, inputString);
        }

        // 커스텀 구분자와 기본 구분자 합치기
        List<String> defaultAndCustomDelimiters = combineDefaultAndCustomDelimiters(customDelimiters);
        // 계산해야할 문자열과 모든 구분자를 리턴
        return new CalculationData(inputString, PatternFactory.buildDelimiterOrPattern(defaultAndCustomDelimiters));
    }

    private static int getIndexOfCustomDelimiterSuffix(String inputString) {
        int i = inputString.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (i == -1)
            throw new IllegalArgumentException(ERROR_MESSAGE);
        return i;
    }

    private static String extractCustomDelimiterSection(int i, String inputString) {
        String subString = inputString.substring(CUSTOM_DELIMITER_PREFIX.length(), i);
        return subString;
    }

    private static String removeCustomDelimiterFromInput(int i, String inputString) {
        return inputString.substring(i + CUSTOM_DELIMITER_SUFFIX.length(), inputString.length());
    }

    private static void extractAndValidateCustomDelimiters(String customDelimiterSection, List<String> customDelimiters) {
        String defaultDelimiterPattern = PatternFactory.buildDelimiterOrPattern(DEFAULT_DELIMITER);
        String[] splitByDefaultDelimiter = customDelimiterSection.split(defaultDelimiterPattern);

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

    private static List<String> combineDefaultAndCustomDelimiters(List<String> customDelimiters) {
        List<String> allDelimiters = customDelimiters;
        Constants.DEFAULT_DELIMITER.stream().forEach(defaultDelimiter -> allDelimiters.add(defaultDelimiter));
        return allDelimiters;
    }
}
