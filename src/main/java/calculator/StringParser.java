package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String EXTRACT_DELIMITER_REGEX = "//(.*?)\\\\n";
    private final String inputString;

    public StringParser(String inputString) {
        this.inputString = inputString;
    }

    public List<Integer> extractNumbers() {
        List<String> parsedString = parseString();

        return parsedString.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> parseString() {
        String customDelimiter = extractCustomDelimiter();
        if (customDelimiter != null) {
            String inputString = this.inputString.replaceAll(EXTRACT_DELIMITER_REGEX, "");
            String[] result = inputString.split(customDelimiter);
            return Arrays.asList(result);
        }

        String[] result = this.inputString.split(DEFAULT_DELIMITER_REGEX);
        return Arrays.asList(result);
    }

    private String extractCustomDelimiter() {
        Pattern pattern = Pattern.compile(EXTRACT_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(this.inputString);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
