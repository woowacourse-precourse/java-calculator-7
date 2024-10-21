package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static String activeSeparator;

    public static String checkCustomSeparator(String input) {
        if (input.startsWith("//")) {
            handleCustomSeparator(input);
            SeparatorValidator.validateCustomDelimiter(input);
            return cleanInput(input);
    }
        return input;
    }


    private static void handleCustomSeparator(String input) {
        Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            SeparatorValidator.validateCustomDelimiterLength(customSeparator);
            activeSeparator = DEFAULT_SEPARATOR + "|" + customSeparator;
            SeparatorValidator.validateOnlyCustomDelimiterUsed(input);
        }
    }

    public static String cleanInput(String input) {
        String[] parts = input.split("\\\\n", 2);

        if (parts[1].isEmpty()) {
            parts[1] = "0";

            return parts[1];
        }

        return parts[1];
    }

    public static String[] splitInput(String token){
        return token.split(activeSeparator);
    }
}
