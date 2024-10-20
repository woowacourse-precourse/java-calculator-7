package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;
import calculator.utils.Splitter;
import calculator.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static String userInput;
    private static List<String> numbers = new ArrayList<>();
    private static int total = 0;

    public static void run() {
        userInput = InputUtils.getInput("덧셈할 문자열을 입력해 주세요.");

        if (userInput.isEmpty()) {
            PrintUtils.print("결과 : " + total);
            return;
        }

        calculating();
    }

    private static void calculating() {
        numbers = Splitter.getCalculationSectionSplitByDelimiter(userInput);
        checkEachInputIsValid();
        getTotal();
        PrintUtils.print("결과 : " + total);
    }

    private static void checkEachInputIsValid() {
        for (String number : numbers) {
            Validator.checkNumberIsValid(number);
        }
    }

    private static void getTotal() {
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
    }
}
