package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

/**
 * 계산기 실행 및 결과 출력을 위한 Controller
 */
public class CalculatorController {
    InputString inputString = new InputString();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    StringValidator stringValidator = new StringValidator();
    Integer result = 0;

    /**
     * 문자열 저장, 계산, 결과 출력을 실행하는 메소드
     */
    public void executeCalculator() {
        saveInputString();
        calculate();
        sendResultMessage();
    }

    /**
     * 문자열을 검증 및 저장하는 메소드
     */
    private void saveInputString() {
        inputString.setUserInput(inputView.enterInputString());
        List<Integer> userOperand = stringValidator.validate(inputString.getUserInput());
        inputString.setUserOperand(userOperand);
    }

    /**
     * Integer로 변환된 문자열을 합산하는 메소드
     */
    private void calculate() {
        result = inputString.getUserOperand().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * 결과 출력 메소드
     */
    private void sendResultMessage() {
        outputView.printResult(result);
    }

}
