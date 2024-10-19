package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;
import calculator.utils.SplitUtils;
import calculator.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static String userInput;
    private static List<String> numberList = new ArrayList<>();
    private static int total = 0;

    public static void run() {
        userInput = InputUtils.getInput("덧셈할 문자열을 입력해 주세요.");
        calculating();
    }

    private static void calculating() {
        numberList = SplitUtils.getCalculationSection(userInput);
        checkEachInputIsValid();
        getTotal();
        PrintUtils.print("결과 : " + total);
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
