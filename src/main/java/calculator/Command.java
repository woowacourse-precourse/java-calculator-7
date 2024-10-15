package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Command(
    String header,
    String content
) {
    private static final Pattern customPattern = Pattern.compile("//(.+?)\\\\n");

    public static Command from(String command) {
        Matcher matcher = customPattern.matcher(command);
        String header = "";
        String content = command;
        if (matcher.find()) {
            header = matcher.group(1);
            content = matcher.replaceAll("");
        }
        return new Command(header, content);
    }
}
