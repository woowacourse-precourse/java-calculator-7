package calculator;

public class InvalidCharValidator {
    private final CustomDelimiterPresenceChecker customDelimiterExistenceVerifier = new CustomDelimiterPresenceChecker();

    private final RegexValidator regexValidator = new RegexValidator();

    private boolean isEmpty(String inputNumber) {
        return inputNumber.isEmpty();
    }

    private boolean validateByRegex(String inputNumber) {
        return regexValidator.validateByRegex(inputNumber);
    }

    private boolean containsInvalidCharacter(String inputNumber) {
        return validateByRegex(inputNumber);
    }

    private String checkForCustomDelimiter(String inputNumber) {

        if (customDelimiterExistenceVerifier.existsCustomDelimiter(inputNumber)) {
            return inputNumber;
        }
        throw new IllegalArgumentException("사용할 수 없는 구분자가 포함되어있습니다");

    }

    public String validateInputNumber(String inputNumber) {
        if (isEmpty(inputNumber)) {
            return inputNumber;
        }

        if (containsInvalidCharacter(inputNumber)) {
            return checkForCustomDelimiter(inputNumber);
        }

        return inputNumber;
    }

}
