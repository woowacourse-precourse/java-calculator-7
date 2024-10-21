package calculator.interfaces.conroller;

import calculator.domain.CalculatorService;
import calculator.domain.Number;
import calculator.interfaces.view.InputView;
import calculator.interfaces.view.OutputView;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(CalculatorService calculatorService, InputView inputView, OutputView outputView) {
        this.calculatorService = calculatorService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /*
     * 계산기를 시작합니다.
     * 사용자 입력을 받고, 문자열 덧셈 계산기를 실행시킵니다.
     * 결과를 화면에 출력합니다.
     */
    public void startCalculator() {
        String userInputStr = inputView.readUserInput();
        long result = 0L;
        if (userInputStr == null || userInputStr.isEmpty()) {
            outputView.printResult(result);
            return;
        }
        try {
            result = calculate(userInputStr);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        outputView.printResult(result);
    }

    private Long calculate(String inputStr) {
        calculatorService.validateUserInput(inputStr);
        String[] splitStrBySeparators = calculatorService.splitStrBySeparators(inputStr);
        List<Number> numberList = calculatorService.makeNumberList(splitStrBySeparators);
        return calculatorService.sum(numberList);
    }

}
