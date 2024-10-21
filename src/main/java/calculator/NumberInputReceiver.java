package calculator;

import camp.nextstep.edu.missionutils.Console;

public class NumberInputReceiver {


    private final InvalidCharValidator invalidCharValidator = new InvalidCharValidator();


    public String inputNumber() {
        String inputNumber = Console.readLine();

        return invalidCharValidator.validateInputNumber(inputNumber);
    }


}
