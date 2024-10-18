package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;
import calculator.utils.SplitUtils;
import calculator.utils.ValidateUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String userInput = InputUtils.getUserInput();
        List<String> splitInput = SplitUtils.getSplitInput(userInput);

        ValidateUtils.checkIsNumericAndPositive(splitInput);

        int total = calculator.getTotal(splitInput);
        PrintUtils.printResult(total);
    }
}
