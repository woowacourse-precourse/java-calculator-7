package calculator;

import calculator.utils.*;

import java.util.List;

public class Calculator {
    private final Splitter splitter;
    private final Validator validator;
    private final StringSumCalculator stringSumCalculator;
    private String userInput;

    public Calculator(Splitter splitter, Validator validator, StringSumCalculator stringSumCalculator) {
        this.splitter = splitter;
        this.validator = validator;
        this.stringSumCalculator = stringSumCalculator;
    }

    public void run() {
        userInput = InputUtils.getInput("덧셈할 문자열을 입력해 주세요.");

        if (userInput.isEmpty()) {
            PrintUtils.print("결과 : " + 0);
            return;
        }

        calculating();
    }

    private void calculating() {
        List<String> strings = splitter.getCalculationSectionSplitByDelimiter(userInput);
        validator.checkEachInputIsValid(strings);
        int total = stringSumCalculator.getTotal(strings);
        PrintUtils.print("결과 : " + total);
    }


}
