package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;
import calculator.utils.SplitUtils;
import calculator.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static String userInput;
    static List<String> numberList = new ArrayList<>();
    static int total = 0;

    public static void run() {
        userInput = InputUtils.getUserInput();
        calculating();
    }

    private static void calculating() {
        numberList = SplitUtils.getCalculationSection(userInput);
        checkEachInputIsValid();
        getTotal();
        PrintUtils.printResult(total);
    }

    private static void checkEachInputIsValid() {
        for (String number : numberList) {
            ValidateUtils.checkNumberIsValid(number);
        }
    }

    private static void getTotal() {
        for (String number : numberList) {
            total += Integer.parseInt(number);
        }
    }
}
