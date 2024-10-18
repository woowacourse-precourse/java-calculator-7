package calculator.domain.machine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String CUSTOM_DELIMITER_REGEX = "//.\\\\n";

    public boolean isCustomDelimiter(String line) {
        Matcher matcher = getMatcher(line);
        return matcher.find();
    }

    public String getCustomDelimiter(String line) {
        Matcher matcher = getMatcher(line);

        if (matcher.find()) {
            String group = matcher.group();
            return group.substring(2, group.length() - 2);
        } else {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 공백일 수 없습니다.");
        }
    }

    public String getOperandLine(String line) {
        Matcher matcher = getMatcher(line);
        return matcher.replaceAll("");
    }

    private Pattern getPattern() {
        return Pattern.compile(CUSTOM_DELIMITER_REGEX);
    }

    private Matcher getMatcher(String line) {
        Pattern pattern = getPattern();
        return pattern.matcher(line);
    }
}
