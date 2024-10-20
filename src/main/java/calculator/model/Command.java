package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Command(
    String header,
    String content
) {
    private static final String CONTAINS_DIGIT_REGEX = ".*\\d.*";
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.+?)\\\\n";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private static final String DELIMITER_FORMAT = "[%s,:]";

    public static Command from(String command) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(command);
        String header = "";
        String content = command;
        if (matcher.find()) {
            header = matcher.group(1);
            content = matcher.replaceAll("");
        }
        if (containsDigit(header)) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자를 포함할 수 없습니다.");
        }
        return new Command(header, content);
    }

    public List<Number> extractNumbers() {
        String splitter = String.format(DELIMITER_FORMAT, header);
        return Arrays.stream(content.split(splitter)).map(Number::from).toList();
    }

    private static boolean containsDigit(String input) {
        return input.matches(CONTAINS_DIGIT_REGEX);
    }
}
