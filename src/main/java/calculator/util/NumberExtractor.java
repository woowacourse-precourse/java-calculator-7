package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class NumberExtractor {

    private static final String NUMBER_REGEX = "\\d*";

    public static List<Integer> extract(String input, List<String> delimiters) {
        input = CustomDelimiterFormatParser.preprocessInput(input);

        String regex = createDelimiterRegex(delimiters);

        String[] splitNumbers = input.split(regex);

        return Arrays.stream(splitNumbers)
                .filter(NumberExtractor::isNotEmpty)
                .map(NumberExtractor::validateAndParseInt)
                .toList();
    }

    private static String createDelimiterRegex(List<String> delimiters) {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    private static boolean isNotEmpty(String splitNumber) {
        return !splitNumber.isEmpty();
    }

    private static Integer validateAndParseInt(String splitNumber) {
        if (!splitNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("유효한 숫자 형식이 아닙니다.");
        }

        return Integer.parseInt(splitNumber);
    }

}
