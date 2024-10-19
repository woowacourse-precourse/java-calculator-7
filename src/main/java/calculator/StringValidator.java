package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    private StringValidator() {
    }

    public static List<String> userInputValidator(String userInput) {
        List<Delimiter> delimiter = delimiterValidator(userInput);
        return setDelimiter(userInput, delimiter);
    }

    public static List<String> setDelimiter(String userInput, List<Delimiter> delimiters) {
        List<String> curDelimiterList = new ArrayList<>();
        for (Delimiter delimiter : delimiters) {
            if (isCustom(delimiter)) {
                curDelimiterList.add(findCustomDelimiter(userInput));
            } else {
                stringFiter(userInput);
                curDelimiterList.add(delimiter.getDelimiter());
            }
        }
        return curDelimiterList;
    }

    public static boolean isCustom(Delimiter delimiter) {
        return delimiter == Delimiter.CUSTOM_DOUBLE_SLASH;
    }

    public static String findCustomDelimiter(String userInput) {
        Pattern customPattern = Pattern.compile("//(.)\\\\n|//(.)\n");
        Matcher matcher = customPattern.matcher(userInput);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            if (delimiter == null) {
                delimiter = matcher.group(2);
            }
            if (delimiter != null) {
                return delimiter;
            } else {
                throw new IllegalArgumentException("유효하지 않은 구분자입니다.");
            }
        }
        return null;
    }

    public static List<Delimiter> delimiterValidator(String userInput) throws IllegalArgumentException {
        List<Delimiter> delimiters = new ArrayList<>();
        for (Delimiter delimiter : Delimiter.values()) {
            if (userInput.contains(delimiter.getDelimiter())) {
                delimiters.add(delimiter);
            }
        }
        return delimiters;
    }

    public static boolean stringFiter(String userInput) throws IllegalArgumentException {
        return Pattern.matches("^[0-9\\p{Punct}n]*", userInput);
    }

}
