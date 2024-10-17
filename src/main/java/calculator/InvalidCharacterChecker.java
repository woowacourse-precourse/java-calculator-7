package calculator;

public class InvalidCharacterChecker {
    private final CustomDelimiterExistenceVerifier customDelimiterExistenceVerifier = new CustomDelimiterExistenceVerifier();

    public boolean containsInvalidCharacter(String inputNumber) {
        return inputNumber.matches(Constants.ALLOWED_CHARACTERS_REGEX);
    }

    public String checkForCustomDelimiter(String inputNumber) {

        if (customDelimiterExistenceVerifier.existsCustomDelimiter(inputNumber)) {
            return inputNumber;
        }
        throw new IllegalArgumentException("사용할 수 없는 구분자가 포함되어있습니다");

    }

}
