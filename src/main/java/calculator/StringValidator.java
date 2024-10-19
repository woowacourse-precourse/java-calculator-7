package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    public static String findCustomDelimiter(String userInput) {
        Pattern customPatter = Pattern.compile("//(.)\\n");
        Matcher matcher = customPatter.matcher(userInput);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String delimiterValidator(String userInput) throws IllegalArgumentException {
        for (Delimiter delimiter : Delimiter.values()) {
            if (userInput.contains(delimiter.getDelimiter())) {
                return delimiter.getDelimiter();
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean stringFiter(String userInput) throws IllegalArgumentException {
        return Pattern.matches("^[0-9\\p{Punct}n]*", userInput);
    }

}
