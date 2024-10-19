package calculator.controller;

import calculator.model.AdditionOperator;
import calculator.model.MultiDelimiter;
import calculator.model.Operator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final MultiDelimiter splitDelimiter = new MultiDelimiter();
    private final Operator additionOperator = new AdditionOperator();
    private final OutputView outputView = new OutputView();

    public void run() {
        String userInput = inputView.receiveUserInput();
        String[] operand = splitDelimiter.splitWithDelimiter(userInput);
        int[] numbs = strToInt(operand);
        int res = additionOperator.calculate(numbs);
        outputView.printResult(res);
    }

    private int[] strToInt(String[] str) {
        return Arrays.stream(str)
                .mapToInt(this::parsePositiveInt)
                .toArray();
    }

    /**
     * 양수 검증 후 문자를 숫자로 반환
     * @param numberStr String
     * @return int
     */
    private int parsePositiveInt(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            if (number < 0) {
                throw new IllegalArgumentException("양수로 구성된 문자열만 가능합니다. 음수 존재 ("+ number + ")");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않는 숫자입니다. " + numberStr, e);
        }
    }

}
