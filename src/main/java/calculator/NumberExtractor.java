package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberExtractor {

    private static final String NUMBER_REGEX = "\\d*";

    private final CustomDelimiterFormatParser formatParser;

    public NumberExtractor() {
        this.formatParser = new CustomDelimiterFormatParser();
    }

    public List<Integer> extract(String input, List<String> delimiters) {
        input = formatParser.preprocessInput(input);

        String regex = createDelimiterRegex(delimiters);

        String[] splitNumbers = input.split(regex.isEmpty() ? input : regex);

        return Arrays.stream(splitNumbers)
                .filter(this::isNotEmpty)
                .map(this::validateAndParseInt)
                .toList();
    }

    private String createDelimiterRegex(List<String> delimiters) {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    private boolean isNotEmpty(String splitNumber) {
        return !splitNumber.isEmpty();
    }

    private Integer validateAndParseInt(String splitNumber) {
        if (!splitNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("유효한 숫자 형식이 아닙니다.");
        }

        return Integer.parseInt(splitNumber);
    }

}
