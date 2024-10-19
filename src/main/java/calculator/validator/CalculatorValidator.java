package calculator.validator;

import calculator.exception.CalculatorErrorCode;
import calculator.exception.CalculatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorValidator {

    private final static Pattern NEGATIVE_NUMBER_PATTERN = Pattern.compile("-\\d+");
    private final static Pattern START_WITH_NUMBER_OR_BLANK_PATTERN = Pattern.compile("^(//.*?\\\\n)?(|\\d.*|\\s.*)");
    private final static Pattern END_WITH_NUMBER_OR_BLANK_PATTERN = Pattern.compile("^(//.*?\\\\n)?(.*\\d$|.*\\s$|)");
    private static final String VALID_PATTERN = "^((//)(.*?)(\\\\n))?(\\d+([,:%s]{1}\\d+)*)*";

    public static void validate(String input, String customSeparator) throws IllegalArgumentException {

        if (hasNegativeNumber(input, customSeparator)) {
            throw new CalculatorException(CalculatorErrorCode.NEGATIVE_NUMBER);
        }
        if (!hasEndWithNumberOrBlank(input)) {
            throw new CalculatorException(CalculatorErrorCode.END_WITH_SEPARATOR_OR_SOMETHING);
        }
        if (!hasStartWithNumberOrBlank(input)) {
            throw new CalculatorException(CalculatorErrorCode.START_WITH_SEPARATOR_OR_SOMETHING);
        }
        if (!isValidPattern(input, customSeparator)) {
            throw new CalculatorException(CalculatorErrorCode.INVALID_EXPRESSION);
        }
    }

    public static boolean hasNegativeNumber(String input, String customSeparator) {
        Matcher matcher = NEGATIVE_NUMBER_PATTERN.matcher(input);

        return !customSeparator.equals("-") && matcher.find();
    }

    public static boolean hasEndWithNumberOrBlank(String input) {
        Matcher matcher = END_WITH_NUMBER_OR_BLANK_PATTERN.matcher(input);

        return matcher.matches();
    }

    public static boolean hasStartWithNumberOrBlank(String input) {
        Matcher matcher = START_WITH_NUMBER_OR_BLANK_PATTERN.matcher(input);

        return matcher.matches();
    }

    public static boolean isValidPattern(String input, String customSeparator) {
        Pattern validPattern = Pattern.compile(VALID_PATTERN.formatted(customSeparator));
        Matcher matcher = validPattern.matcher(input);

        return matcher.matches();
    }
}
