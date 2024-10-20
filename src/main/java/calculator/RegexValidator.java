package calculator;

import static calculator.Constants.ALLOWED_CHARACTERS_REGEX;
import static calculator.Constants.CHECK_ONLY_NUMBERS;
import static calculator.Constants.NO_DIGITS;

public class RegexValidator {
    public boolean validateByRegex(String inputNumber) {
        return inputNumber.matches(ALLOWED_CHARACTERS_REGEX) || inputNumber.matches(CHECK_ONLY_NUMBERS)
                || inputNumber.matches(NO_DIGITS);
    }
}
