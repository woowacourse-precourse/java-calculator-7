package calculator.input;

import calculator.input.error.InputErrorController;
import calculator.input.error.InputErrorType;
import calculator.staticValue.RegexPatterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {


    private static final InputValidator inputValidator = new InputValidator();

    public boolean isInputEmpty(String input) {
        return input.isEmpty();
    }


    public boolean matchesPattern(String input, String regex) {
        return createMatcher(input, regex).find();
    }

    private Matcher createMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }

    public Matcher findCustomizedSeparator(String input) {
        Matcher matcher = createMatcher(input, RegexPatterns.CUSTOM_SEPARATOR.getValue());

        if (matcher.find()) {
            return matcher;
        } else {
            throw new InputErrorController(InputErrorType.CANT_FIND_CUSTOM_SEPARATOR);
        }
    }


    public void validateInput(String[] splitInputs) {

        for (String input : splitInputs) {
            validateNoInvalidCharacters(input);
        }

        validateNoDashInInputs(splitInputs);

        if (!containsOnlyPositiveNumbers(splitInputs)) {
            if (splitInputs.length == 0 | splitInputs[0].isEmpty()) {
                return;
            }
            throw new InputErrorController(InputErrorType.NEED_POSITIVE_NUMBER);
        }

    }


    private void validateNoInvalidCharacters(String input) {
        if (inputValidator.matchesPattern(input,
                RegexPatterns.INVALID_CHAR.getValue())) {
            throw new InputErrorController(InputErrorType.NEED_NUMBER_OR_SEPARATOR);
        }
    }

    private boolean containsOnlyPositiveNumbers(String[] splitInputNumbers) {
        for (String number : splitInputNumbers) {

            if (!inputValidator.matchesPattern(number, RegexPatterns.POSITIVE_NUMBER.getValue())) {
                System.out.println("내가 진짜 범인: " + number);
                return false;
            }

        }
        return true;
    }

    private void validateNoDashInInputs(String[] splitInputNumbers) {
        for (String token : splitInputNumbers) {
            if (token.contains("-")) {
                throw new InputErrorController(InputErrorType.NEED_POSITIVE_NUMBER);
            }
        }
    }

}
