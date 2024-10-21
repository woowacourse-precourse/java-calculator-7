package calculator.controller;

import calculator.domain.SumCalculator;
import calculator.util.NumberValidationUtil;
import calculator.util.SeparatorValidationUtil;
import calculator.util.SplitStringUtil;
import calculator.view.ConsoleView;
import java.math.BigInteger;

public class CalculatorController {

    private final ConsoleView view;
    private final SumCalculator calculator;

    public CalculatorController(ConsoleView view, SumCalculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    /**
     * 사용자가 입력한 문자열을 받아 구분자와 숫자를 분리한 후, 구분자와 숫자 문자열의 형식을 검증하고, 숫자들을 더한 값을 출력하는 메서드. 1. 입력 문자열을 구분자 문자열과 숫자 문자열로 분리 2.
     * 구분자 문자열이 유효한지 검증 3. 숫자 문자열이 유효한지 검증 4. 계산 후 결과 출력 만약 잘못된 값이 입력되면 IllegalArgumentException을 던지고 에러 메시지를 출력.
     */

    public void run() {
        String input = view.getUserInput();

        String[] splitStrings = new String[0];
        String customSeparatorString = "";
        String numberString = "";
        String customSeparator = "";

        if (!input.isEmpty()) {
            splitStrings = SplitStringUtil.splitInputString(input);
            customSeparatorString = splitStrings[0];
            numberString = splitStrings[1];
        }

        try {
            if (!input.isEmpty() && !splitStrings[0].isEmpty()) {
                SeparatorValidationUtil.validateSeparatorStringFormat(customSeparatorString);
                customSeparator += customSeparatorString.substring(2, customSeparatorString.length() - 2);
            }

            if (customSeparator.equals("\\")) {
                customSeparator += "\\";
            }

            if (!input.isEmpty() && !splitStrings[1].isEmpty()) {
                NumberValidationUtil.validateNumberString(numberString, customSeparator);
            }

            BigInteger result = calculator.Sum(numberString, customSeparator);

            view.printResult(result);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
