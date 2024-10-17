package calculator.delimiter;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorManager {
    public static final String CUSTOM_SEPARATOR_PATTERN = "^//.+?\\\\n";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);

    public boolean add(String input, Separators separators) {
        Optional<Separator> customSeparator = findCustomSeparator(input);

        if (customSeparator.isEmpty()) {
            return false;
        }

        separators.add(customSeparator.get());
        return true;
    }

    private Optional<Separator> findCustomSeparator(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (!matcher.find()) {
            return Optional.empty();
        }

        int matchStart = matcher.start();
        int matchEnd = matcher.end();
        String inputSeparator = input.substring(matchStart + 2, matchEnd - 2);

        return Optional.of(new Separator(inputSeparator));
    }

    public String extractAfterCustomSeparator(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (!matcher.find()) {
            return input;
        }

        return input.substring(matcher.end());
    }
}
