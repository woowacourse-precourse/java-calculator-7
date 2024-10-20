package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Command(
    String header,
    String content
) {
    private static final Pattern customPattern = Pattern.compile("^//(.+?)\\\\n");

    public static Command from(String command) {
        Matcher matcher = customPattern.matcher(command);
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
        String splitter = String.format("[%s,:]", header);
        return Arrays.stream(content.split(splitter)).map(Number::from).toList();
    }

    private static boolean containsDigit(String input) {
        return input.matches(".*\\d.*");
    }
}
