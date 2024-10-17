package calculator;

import camp.nextstep.edu.missionutils.Console;

public class NumberInPutter {


    private final InvalidCharacterChecker invalidCharacterChecker = new InvalidCharacterChecker();


    public String inputNumber() {
        String inputNumber = Console.readLine();

        if (invalidCharacterChecker.containsInvalidCharacter(inputNumber)) {
            return invalidCharacterChecker.checkForCustomDelimiter(inputNumber);
        }

        return inputNumber;
    }


}
