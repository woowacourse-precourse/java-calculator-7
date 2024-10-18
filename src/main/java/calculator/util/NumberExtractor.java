package calculator.util;

import calculator.exception.util.NumberExtractorErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static calculator.util.DelimiterConstants.DEFAULT_DELIMITERS;

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

    private static String[] mergeDelimiters(String customDelimiter) {
        String[] mergedDelimiters = new String[DEFAULT_DELIMITERS.length + 1];
        System.arraycopy(DEFAULT_DELIMITERS, 0, mergedDelimiters, 0, DEFAULT_DELIMITERS.length);
        mergedDelimiters[DEFAULT_DELIMITERS.length] = customDelimiter;
        return mergedDelimiters;
    }

    private static void validateToken(String token) {
        token = token.trim(); // 공백 제거

        // 빈 문자열 검사
        if (token.isEmpty()) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.INVALID_SPLIT.getMessage());
        }

        // 숫자 확인
        if (!isNumeric(token)) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.INVALID_CHARACTER.getMessage());
        }

        // long 타입으로 변환하여 범위 검사
        long number = Long.parseLong(token);

        // 0 또는 음수 확인
        if (number <= 0) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.NEGATIVE_OR_ZERO_NUMBER.getMessage());
        }

        // int 범위 초과 확인
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(NumberExtractorErrorMessage.OUT_OF_INT_RANGE.getMessage());
        }
    }

    private static boolean isNumeric(String token) {
        // 정수 확인
        return token.matches("-?\\d+");
    }
}