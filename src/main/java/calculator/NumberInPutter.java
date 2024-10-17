package calculator;

import camp.nextstep.edu.missionutils.Console;

public class NumberInPutter {

    private final NegativeNumberValidator negativeNumberValidator = new NegativeNumberValidator();

    private final InvalidCharacterChecker undefinedDelimiterVerifier = new InvalidCharacterChecker();


    public String inputNumber() {
        String inputNumber = Console.readLine();

        if (undefinedDelimiterVerifier.containsUndefinedDelimiter(inputNumber)) {
            return negativeNumberValidator.validateNegativeNumber(inputNumber);
        }

        return negativeNumberValidator.validateNegativeNumber(Console.readLine());
    }


}
