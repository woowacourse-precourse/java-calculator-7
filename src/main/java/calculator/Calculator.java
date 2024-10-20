package calculator;

import calculator.utils.InputUtils;
import calculator.utils.PrintUtils;
import calculator.utils.Splitter;
import calculator.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String userInput;
    private List<String> numbers = new ArrayList<>();
    private int total = 0;

    public void run() {
        userInput = InputUtils.getInput("덧셈할 문자열을 입력해 주세요.");

        if (userInput.isEmpty()) {
            PrintUtils.print("결과 : " + total);
            return;
        }

        calculating();
    }

    private void calculating() {
        numbers = Splitter.getCalculationSectionSplitByDelimiter(userInput);
        checkEachInputIsValid();
        getTotal();
        PrintUtils.print("결과 : " + total);
    }

    private void checkEachInputIsValid() {
        for (String number : numbers) {
            Validator.checkIsNumberValid(number);
        }
    }

    private void getTotal() {
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
    }
}
