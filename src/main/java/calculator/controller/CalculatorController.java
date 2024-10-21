package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private InputView inputView;
    private OutputView outputView;
    private CalculatorService calculatorService = CalculatorService.getInstance();

    // start : singleton
    private CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private static final class InnerCalculatorController {
        private static final CalculatorController INSTANCE = new CalculatorController();
    }

    public static CalculatorController getInstance() {
        return InnerCalculatorController.INSTANCE;
    }
    // end : singleton


    /**
     * 실질적인 프로그램 시작점
     */
    public void calcFromString() {
        String userInput = requestInputCalcString();

        // Service에서 처리 후, 결과를 받아 출력
        Integer calcResult = calculatorService.calcFromString(userInput);

        outputView.printResult(calcResult);

    }

    /**
     * 사용자에게 프로그램 안내 메시지와 입력값을 입력받아서 리턴
     * @return 사용자의 입력 String
     */
    private String requestInputCalcString() {
        return inputView.requestInputCalcString();
    }

}
