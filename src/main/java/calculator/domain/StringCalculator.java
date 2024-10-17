package calculator.domain;

import calculator.constants.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DOUBLE_SLASH = "//";
    private static final String ESCAPE = "\\n";
    private static final String BASIC_DELIMITER = Constants.COMMA + "|" + Constants.COLON;
    private static final String REGEX = "\\//(.)\\\\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int FIRST_LETTER_INDEX
            = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return Constants.ZERO;
        }
        if (containsCustom(input)) {
            return calculateSumByMatcher(input);
        }
        if (containsBasicDelimiter(input)) {
            return calculateSum(splitInput(input));
        }

        UserInputValidator.validateDelimiter(input);

        return stringToInteger(input);
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean containsCustom(String input) {
        return input.contains(DOUBLE_SLASH) && input.contains(ESCAPE);
    }

    private static boolean containsBasicDelimiter(String input) {
        return input.contains(Constants.COMMA) || input.contains(Constants.COLON);
    }

    private static int calculateSumByMatcher(String input) {
        Matcher matcher = getMatcher(input);

        UserInputValidator.validateCustomPresence(matcher);

        return calculateSum(splitInputByCustom(matcher));
    }

    private static int calculateSum(String[] strArr) {
        int sum = 0;
        for (String str : strArr) {
            int number = stringToInteger(str);
            UserInputValidator.validatePositive(number);
            sum += number;
        }
        return sum;
    }

    private static Matcher getMatcher(String input) {
        return PATTERN.matcher(input);
    }

    private static String[] splitInput(String input) {
        return input.split(BASIC_DELIMITER);
    }

    private static String[] splitInputByCustom(Matcher matcher) {
        String custom = findCustomGroup(matcher);
        String string = findStringGroup(matcher, custom);
        return string.split(custom);
    }

    private static String findCustomGroup(Matcher matcher) {
        return matcher.group(FIRST);
    }

    private static String findStringGroup(Matcher matcher, String custom) {
        String string = matcher.group(SECOND);
        checkUndefinedDelimiter(string, custom);
        return string;
    }

    private static void checkUndefinedDelimiter(String string, String delimiter) {
        char asciiOfDelimiter = delimiter.charAt(FIRST_LETTER_INDEX);
        char letter;

        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            UserInputValidator.validateDefinedCustom(letter, asciiOfDelimiter);
        }
    }

    private static int stringToInteger(String string) {
        UserInputValidator.validateHasNumber(string);
        return Integer.parseInt(string);
    }
}
