package calculator.separator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorManager {
    public static final String CUSTOM_SEPARATOR_START_REGEX = "//";
    public static final String CUSTOM_SEPARATOR_END_REGEX = "\\n";
    public static final String CUSTOM_SEPARATOR_REGEX = "^//.+?\\\\n";
    public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    public Separators findAllCustomSeparators(String input) {
        Separators separators = Separators.empty();

        Optional<Separator> separator;
        while ((separator = findCustomSeparator(input)).isPresent()) {
            separators.add(separator.get());
            input = extractAfterCustomSeparator(input);
        }

        return separators;
    }

    private Optional<Separator> findCustomSeparator(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if (!matcher.find()) {
            return Optional.empty();
        }

        int matchStart = matcher.start();
        int matchEnd = matcher.end();
        String customSeparator = input.substring(
                matchStart + CUSTOM_SEPARATOR_START_REGEX.length(),
                matchEnd - CUSTOM_SEPARATOR_END_REGEX.length());

        return Optional.of(new Separator(customSeparator));
    }

    private String extractAfterCustomSeparator(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if (!matcher.find()) {
            return input;
        }

        return input.substring(matcher.end());
    }

    public String sliceCustomSeparators(String input) {
        Matcher matcher;
        while ((matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input)).find()) {
            input = input.substring(matcher.end());
        }

        return input;
    }
}
