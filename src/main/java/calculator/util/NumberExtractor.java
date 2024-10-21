package calculator.util;

import calculator.exception.util.NumberExtractorErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    public static int[] extract(String str, String[] delimiters) {
        String delimiterRegex = String.join("|", delimiters);

        if (str.trim().isEmpty()) {
            return new int[0];
        }

        String[] tokens = str.split(delimiterRegex);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            validateToken(token);
            numbers.add(Integer.parseInt(token));
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }

    public static String[] mergeDelimiters(String customDelimiter) {
        String[] mergedDelimiters = new String[DelimiterConstants.DEFAULT_DELIMITERS.length + 1];
        System.arraycopy(DelimiterConstants.DEFAULT_DELIMITERS, 0, mergedDelimiters, 0, DelimiterConstants.DEFAULT_DELIMITERS.length);
        mergedDelimiters[DelimiterConstants.DEFAULT_DELIMITERS.length] = customDelimiter;
        return mergedDelimiters;
    }

    private static void validateToken(String token) {
        token = token.trim();

        // 빈 문자열이라면,
        if (token.isEmpty()) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.INVALID_SPLIT.getMessage());
        }

        // 숫자가 아니라면,
        if (!isNumeric(token)) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.INVALID_CHARACTER.getMessage());
        }

        long number = Long.parseLong(token);

        // 0 또는 음수라면,
        if (number <= 0) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.NEGATIVE_OR_ZERO_NUMBER.getMessage());
        }

        // int 범위 초과한다면,
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.OUT_OF_INT_RANGE.getMessage());
        }
    }

    private static boolean isNumeric(String token) {
        // 정수 확인
        return token.matches("-?\\d+");
    }
}