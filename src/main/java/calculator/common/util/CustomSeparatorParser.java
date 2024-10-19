package calculator.common.util;

import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_REGEX;

import calculator.model.Separator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorParser {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    private static final int CUSTOM_SEPARATOR_GROUP_INDEX = 1;
    private static final int OPERATION_STRING_GROUP_INDEX = 2;

    private final Matcher matcher;

    public CustomSeparatorParser(String message) {
        matcher = CUSTOM_SEPARATOR_PATTERN.matcher(message);
    }

    public boolean hasCustomSeparator() {
        return matcher.matches();
    }

    public Separator extractSeparator() {
        return Separator.from(matcher.group(CUSTOM_SEPARATOR_GROUP_INDEX));
    }

    public String stripCustomSeparator() {
        return matcher.group(OPERATION_STRING_GROUP_INDEX);
    }
}
