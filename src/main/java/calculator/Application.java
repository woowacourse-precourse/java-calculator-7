package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;
import calculator.utils.SplitUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        DataVerification dataVerification = new DataVerification();

        String userInput = InputUtils.getUserInput();
        dataVerification.checkIsInputEmpty(userInput);

        List<String> splitInput = SplitUtils.getSplitInput(userInput);

        dataVerification.checkIsPositiveNumber(splitInput);
        dataVerification.checkHasNumberFormat(splitInput);

        int total = calculator.getTotal(splitInput);
        PrintUtils.printResult(total);
    }
}
