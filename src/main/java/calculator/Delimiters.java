package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {

    private static final String BASIC_DELIMITERS_COMMA = ",";
    private static final String BASIC_DELIMITERS_COLON = ":";
    private static final String CUSTOM_DELIMITERS_PREFIX = "//";
    private static final String CUSTOM_DELIMITERS_SUFFIX = "\\\\n";
    private static final String VALID_STRING_REGEX_TEMPLATE = "[^0-9%s]+";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.*?)\\\\n";

    private List<String> separators;

    public Delimiters(String rawString) {
        this.separators = initializeDefaultSeparators();
        findCustomSeparator(rawString);
        checkNotDelimiter(rawString);
    }

    private List<String> initializeDefaultSeparators() {
        List<String> defaultSeparators = new ArrayList<>();
        defaultSeparators.add(BASIC_DELIMITERS_COMMA);
        defaultSeparators.add(BASIC_DELIMITERS_COLON);
        defaultSeparators.add(CUSTOM_DELIMITERS_PREFIX);
        defaultSeparators.add(CUSTOM_DELIMITERS_SUFFIX);

        return defaultSeparators;
    }

    private void findCustomSeparator(String rawString) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(rawString);

        while (matcher.find()) {
            separators.add(matcher.group(1));
        }
    }

    private void checkNotDelimiter(String rawString) {
        String validCharactersRegex = String.format(VALID_STRING_REGEX_TEMPLATE, String.join("", separators));
        Matcher matcher = Pattern.compile(validCharactersRegex).matcher(rawString);

        while (matcher.find()) {
            throw new IllegalArgumentException("구분자 외 문자는 입력할 수 없습니다.");
        }
    }
}
